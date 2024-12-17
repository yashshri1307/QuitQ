package com.hexaware.quitq.restcontroller;
import java.util.HashMap;
import java.util.Map;

/* 
 * File: LoginRestController
 * Author: Yash Shrivastava
 * Date Created: 2024-11-14
 * Description: Login Controller will have API mappings 
 *              for role-specific login authentication 
 *              and will return tokens
 */
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.quitq.dto.AuthRequest;
import com.hexaware.quitq.service.ICustomerService;
import com.hexaware.quitq.service.JwtService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class LoginRestController {

    @Autowired
    ICustomerService service;

    @Autowired
    JwtService jwtService;
    

    @Autowired
    AuthenticationManager authenticationManager;

    Logger logger = LoggerFactory.getLogger(LoginRestController.class);
    

    //customer
    @PostMapping("/customer/login")
    public String customerLogin(@RequestBody AuthRequest authRequest) {
    	logger.info("yes iam in login controller customer login");
    	System.out.println("yes iam in login controller customer login");
        return authenticateAndGenerateToken(authRequest, "CUSTOMER");
    }

    // Supplier
    @PostMapping("/supplier/login")
    public String supplierLogin(@RequestBody AuthRequest authRequest) {
    	System.out.println("Yes i am in supplierlogin of loginrestcontroller");
        return authenticateAndGenerateToken(authRequest, "SUPPLIER");
    }

    // Admin 
    @PostMapping("/admin/login")
    public String adminLogin(@RequestBody AuthRequest authRequest) {
        return authenticateAndGenerateToken(authRequest, "ADMIN");
    }

    // Helper method for role-specific authentication and token generation
    private String authenticateAndGenerateToken(AuthRequest authRequest, String requiredRole) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));

        String token = null;

        if (authentication.isAuthenticated()) {
            String role = service.getUserRole(authRequest.getUsername());

            if (!requiredRole.equalsIgnoreCase(role)) {
                logger.info("Access Denied: User role does not match the required role [" + requiredRole + "]");
                throw new UsernameNotFoundException("Access Denied: Incorrect role for this endpoint");
            }

            // Generate JWT token
            token = jwtService.generateToken(authRequest.getUsername());
            System.out.println("yes iam in login controller customer login");
            logger.info("Tokens : " + token);
        } else {
            logger.info("Invalid Credentials");
            throw new UsernameNotFoundException("Invalid Username or Password");
        }

        return token;
    }
    
    @GetMapping("/fetch-username")
    public ResponseEntity<Map<String, String>> getUsernameByToken(@RequestHeader("Authorization") String token) {
        try {
            // Call the service to extract the username using the JWT token
            String username = jwtService.getUsernameFromToken(token);
            
            // Create a map to return as JSON response
            Map<String, String> response = new HashMap<>();
            response.put("username", username);
            
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            // Return a JSON response with an error message
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", "Invalid or expired token");
            return ResponseEntity.status(401).body(errorResponse);
        }
    }
}
