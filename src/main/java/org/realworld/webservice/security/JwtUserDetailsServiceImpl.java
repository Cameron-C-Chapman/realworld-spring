package org.realworld.webservice.security;

import org.realworld.webservice.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class JwtUserDetailsServiceImpl implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = new User();
        user.setId(new Long(9));
        user.setUsername("testing this jwt wiring");
        user.setEmail("jwtisworking@cool.com");
        user.setPassword("$2y$10$/6v2u1GupcKz0W0Ys0IVMeufeJu7DGS/tkHGu1cr9tOLG4b0pikUy");


        if (user == null) {
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
        } else {
            return JwtUserFactory.create(user);
        }
    }

}
