package org.realworld.webservice.data;

import org.realworld.webservice.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class UserDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    UserRowMapper userRowMapper;

    @Value("${sql.getUserByUsername}")
    private String getUserByUsername;

    public User getUserByUsername(String username) {
        return jdbcTemplate.queryForObject(getUserByUsername, new Object[]{username}, userRowMapper);
    }
}
