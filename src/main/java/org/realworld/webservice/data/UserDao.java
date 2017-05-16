package org.realworld.webservice.data;

import org.realworld.webservice.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class UserDao {

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    UserRowMapper userRowMapper;

    @Value("${sql.getUserByEmail}")
    private String getUserByEmail;

    public User getUserByEmail(String email) {
        Map<String, Object> params = new HashMap<>(1);
        params.put("email", email);
        return namedParameterJdbcTemplate.queryForObject(getUserByEmail, params, userRowMapper);
    }

}