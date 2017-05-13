package org.realworld.webservice.security;

import org.realworld.webservice.manager.UserTransactionManager;
import org.realworld.webservice.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class JwtUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserTransactionManager userTransactionManager;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.userTransactionManager.getUserByUsername(username);
        return Optional.ofNullable(user)
                .map(JwtUserFactory::create)
                .orElseThrow(() ->
                        new UsernameNotFoundException(
                                String.format("No user found with username '%s'.", username)
                        )
                );
    }

}
