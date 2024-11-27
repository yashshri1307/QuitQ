package com.hexaware.quitq.restcontroller;
/* File: LoginRestController
 * Author: Yash Shrivastava
 * Date Created: 2024-11-14
 * Description: Login Controller will have api mapping 
 *                    for login authentication        
                      and will return token
 */
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.quitq.dto.AuthRequest;
import com.hexaware.quitq.service.ICustomerService;
import com.hexaware.quitq.service.JwtService;

@RestController
@RequestMapping("/api/login")
public class LoginRestController {
	
	@Autowired
	ICustomerService service;
	
	@Autowired
	JwtService jwtService;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	Logger logger = LoggerFactory.getLogger(LoginRestController.class);

	
	@PostMapping("/authenticate")
	public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));

		String token = null;

		if (authentication.isAuthenticated()) {

			// call generate token method from jwtService class

			token = jwtService.generateToken(authRequest.getUsername());

			logger.info("Token : " + token);

		} else {

			logger.info("invalid");

			throw new UsernameNotFoundException("UserName or Password in Invalid / Invalid Request");

		}

		return token;

	}
}
