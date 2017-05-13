package org.realworld.webservice.security;

import org.realworld.webservice.data.UserDao;
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
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.userDao.getUserByUsername(username);
        return Optional.ofNullable(user)
                .map(JwtUserFactory::create)
                .orElseThrow(() ->
                        new UsernameNotFoundException(
                                String.format("No user found with username '%s'.", username)
                        )
                );
    }

}
