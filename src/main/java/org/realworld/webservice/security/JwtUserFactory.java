package org.realworld.webservice.security;

import org.realworld.webservice.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class JwtUserFactory {

    private JwtUserFactory() {
    }

    public static JwtUser create(User user) {

        return new JwtUser(
                user.getUsername(),
                user.getEmail(),
                user.getPassword(),
                mapToAuthorities()
        );
    }

    private static List<GrantedAuthority> mapToAuthorities() {
        List<String> authorities = new ArrayList<String>();
        authorities.add("user");

        return authorities.stream()
                .map(authority -> new SimpleGrantedAuthority(authority))
                .collect(Collectors.toList());
    }

}
