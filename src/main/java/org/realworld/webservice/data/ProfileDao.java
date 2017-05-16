package org.realworld.webservice.data;

import org.realworld.webservice.model.Profile;
import org.realworld.webservice.model.Tags;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class ProfileDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    ProfileRowMapper profileRowMapper;

    @Autowired
    FollowerRowMapper followerRowMapper;

    @Value("${sql.getProfileByUsername}")
    private String getProfileByUsername;

    @Value("${sql.searchForFollower}")
    private String searchForFollower;

    public Profile getProfileByUsername(String username) {
        return jdbcTemplate.queryForObject(getProfileByUsername, new Object[]{username}, profileRowMapper);
    }

    public Boolean isFollower(String username, String email) {
        Long count = jdbcTemplate.queryForObject(searchForFollower, new Object[]{username, email}, followerRowMapper);
        return count > 0;
    }
}
