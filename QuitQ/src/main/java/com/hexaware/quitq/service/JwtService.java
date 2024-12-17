package com.hexaware.quitq.service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.hexaware.quitq.entities.UserInfo;
import com.hexaware.quitq.repository.UserInfoRepository;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {
	
	@Autowired
	UserInfoRepository userInfoRepository;

	public static final String SECRET = "5367566B59703373367639792F423F4528482B4D6251655468576D5A71347437";

	// BELOW METHODS GENERATE AND GIVEN TOKEN
	
	public String createToken(Map<String, Object> claims, String username) {

		return Jwts.builder().setClaims(claims).setSubject(username).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 1000 * 600 * 300))
				.signWith(getSignKey(), SignatureAlgorithm.HS256).compact();

	}


	private Key getSignKey() {

		byte[] keyBytes = Decoders.BASE64.decode(SECRET);

		return Keys.hmacShaKeyFor(keyBytes);
	}

	public String generateToken(String username) {

		Map<String, Object> claims = new HashMap<>();

		return createToken(claims, username);

	}
//	public String generateToken(String username, String role) {
//	    Map<String, Object> claims = new HashMap<>();
//	    return createToken(claims, username, role);
//	}
	
	
	public String getUsernameFromToken(String token) {
        // Extract the username from the JWT token
        String jwtToken = token.substring(7); // Remove "Bearer " from the token
        
        String username = extractUsername(jwtToken);

        // Fetch the user info from the repository using the extracted username (email)
        UserInfo userInfo = userInfoRepository.findByEmail(username)
            .orElseThrow(() -> new RuntimeException("User not found"));

        // Return the username or any user-specific details you need
        return userInfo.getName();
    }

	
	// BELOW METHODS HELP TO READ TOKEN FROM CLIENT AND GET Claims , username, exp time etc from token
	
	
	private Claims extractAllClaims(String token) {

		return Jwts.parserBuilder().setSigningKey(getSignKey()).build().parseClaimsJws(token).getBody();

	}

	public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {

		final Claims claims = extractAllClaims(token);
		

		return claimsResolver.apply(claims);

	}

	 public String extractUsername(String token) {
	        return extractClaim(token, Claims::getSubject);
	    }

	    public Date extractExpiration(String token) {
	        return extractClaim(token, Claims::getExpiration);
	    }

	
	    private Boolean isTokenExpired(String token) {
	        return extractExpiration(token).before(new Date());
	    }

	    public Boolean validateToken(String token, UserDetails userDetails) {
	        final String username = extractUsername(token);
	        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	    } 
	
}
