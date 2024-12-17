package com.hexaware.quitq.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.hexaware.quitq.filter.JwtAuthFilter;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Autowired
    JwtAuthFilter authFilter;

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserInfoUserDetailsService();
    }

    @Bean
    public SecurityFilterChain getSecurityFilterChain(HttpSecurity http) throws Exception {
        return http
                .cors().and()
                .csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/v3/api-docs/**","/swagger-ui/**","/api/customer/add","/api/product/getall","/api/fetch-username", "/api/supplier/add", "/api/customer/login", "/api/supplier/login", "/api/admin/login","/api/admins/add", "/api/orders/addorder")
                .permitAll()
                .requestMatchers("/api/customer/**").hasAuthority("CUSTOMER")
                .requestMatchers("/api/orders/**").hasAuthority("CUSTOMER")
                .requestMatchers("/api/supplier/**").hasAuthority("SUPPLIER")
                .requestMatchers("/api/admins/**").hasAuthority("ADMIN")
                .anyRequest().authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authenticationProvider(authenticationProvider())
                .addFilterBefore(authFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.addAllowedOriginPattern("*"); 
        configuration.addAllowedMethod("*"); 
        configuration.addAllowedHeader("*"); 
        configuration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
}
