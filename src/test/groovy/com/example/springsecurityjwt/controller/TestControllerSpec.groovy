package com.example.springsecurityjwt.controller

import com.example.springsecurityjwt.services.CustomUserDetailsService
import com.example.springsecurityjwt.util.JwtUtil
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import spock.lang.Specification

import java.util.stream.Collectors

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup

class TestControllerSpec extends Specification {

    AuthenticationManager authenticationManager

    CustomUserDetailsService userDetailsService = Mock(CustomUserDetailsService)

    JwtUtil jwtUtil = new JwtUtil()

    MockMvc mockMvc = standaloneSetup(new TestController(authenticationManager, userDetailsService, jwtUtil)).build()

    def "Given an call with method GET, answer ok "() {
        when:
        def test = testAuthenticate()

        then:
        test.status == 200
    }

    def testAuthenticate() {
        mockMvc.perform(MockMvcRequestBuilders.get("/test")).andReturn().response
    }

    def singleLine(String content) {
        content.trim().lines().map({ line -> line.trim() }).collect(Collectors.joining())
    }


}
