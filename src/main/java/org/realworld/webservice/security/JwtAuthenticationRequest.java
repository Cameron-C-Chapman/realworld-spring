package org.realworld.webservice.security;

public class JwtAuthenticationRequest {

    public JwtAuthenticationRequestUser user;

    public JwtAuthenticationRequest() {
        super();
    }

    public JwtAuthenticationRequest(String email, String password) {
        this.user = new JwtAuthenticationRequestUser(email, password);
    }

    public JwtAuthenticationRequestUser getUser() {
        return this.user;
    }

    public void setUser(JwtAuthenticationRequestUser user) {
        this.user = user;
    }

}