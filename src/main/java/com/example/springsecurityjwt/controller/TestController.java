package com.example.springsecurityjwt.controller;


import com.example.springsecurityjwt.models.AuthenticationRequest;
import com.example.springsecurityjwt.models.AuthenticationResponse;
import com.example.springsecurityjwt.services.CustomUserDetailsService;
import com.example.springsecurityjwt.util.JwtUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class TestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestController.class);

    private AuthenticationManager authenticationManager;

    private CustomUserDetailsService userDetailsService;

    private JwtUtil jwtUtil;

    @Autowired
    public TestController(AuthenticationManager authenticationManager, CustomUserDetailsService userDetailsService, JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.jwtUtil = jwtUtil;
    }

    @GetMapping("/test")
    public ResponseEntity<String> testAuthenticate() {
        return ResponseEntity.ok("Hello World");
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> doAuthenticationWithToken(@RequestBody AuthenticationRequest authenticationRequest) {

        try {
            authenticationManager.
                    authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUserName(), authenticationRequest.getPassword()));
        } catch (BadCredentialsException e) {
            LOGGER.info("BadCredentialsException: {}", e.getMessage());
            LOGGER.info(e.toString());
        } catch (Exception e) {
            LOGGER.info("Error: {}", e.getMessage());
            LOGGER.info(e.toString());
        }
        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUserName());
        final String jwt = jwtUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

}
