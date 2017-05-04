package org.realworld.webservice.data;

import org.realworld.webservice.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class AuthorDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private AuthorRowMapper authorRowMapper;

    public User getAuthorById(Long id) {
        return jdbcTemplate.queryForObject("select username, bio, image from users where id=1", authorRowMapper);
    }
}
