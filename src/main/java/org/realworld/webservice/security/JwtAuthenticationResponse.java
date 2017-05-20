package org.realworld.webservice.security;

import org.realworld.webservice.model.User;

public class JwtAuthenticationResponse {

    private final User user;

    public JwtAuthenticationResponse(User user, String token) {
        this.user = user;
        this.user.setToken(token);
    }

    public User getUser() {
        return user;
    }

}