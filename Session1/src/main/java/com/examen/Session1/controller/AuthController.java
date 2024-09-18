package com.examen.Session1.controller;

import com.examen.Session1.domain.UserMaster;
import com.examen.Session1.domain.UserResponse;
import com.examen.Session1.security.JwtHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {


    @Autowired
    AuthenticationManager manager;
    @Autowired
    JwtHelper jwtHelper;
    @Autowired
    UserDetailsService userDetailsService;


    @PostMapping("/login")
    public ResponseEntity<UserResponse> auth(@RequestBody UserMaster request){
        doAuthenticate(request.getUsername(),request.getPassword());
        UserDetails userDetails=userDetailsService.loadUserByUsername(request.getUsername());
        String token=jwtHelper.generateToken(userDetails);
        UserResponse response= UserResponse.builder()
                .jwtToken(token)
                .username(userDetails.getUsername())
                .build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    private void doAuthenticate(String username, String password) {
        UsernamePasswordAuthenticationToken authenticationToken=new UsernamePasswordAuthenticationToken(username,password);
        manager.authenticate(authenticationToken);
    }
}

