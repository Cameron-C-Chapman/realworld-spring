package org.realworld.webservice.controller;

import org.realworld.webservice.data.UserDao;
import org.realworld.webservice.model.User;
import org.realworld.webservice.security.JwtAuthenticationRequest;
import org.realworld.webservice.security.JwtAuthenticationResponse;
import org.realworld.webservice.security.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Value("${jwt.header}")
    private String tokenHeader;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "users/login", method = RequestMethod.POST)
    public ResponseEntity<?> userLogin(@RequestBody JwtAuthenticationRequest authenticationRequest) throws AuthenticationException {

        // validate credentials and set authentication
        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationRequest.getUser().getEmail(),
                        authenticationRequest.getUser().getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // load authenticated users details and generate token
        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUser().getEmail());
        final String token = jwtTokenUtil.generateToken(userDetails);

        // get user
        User user = userDao.getUserByEmail(authenticationRequest.getUser().getEmail());

        // return authenticated user
        return ResponseEntity.ok(new JwtAuthenticationResponse(user, token));
    }

}