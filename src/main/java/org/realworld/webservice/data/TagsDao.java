package org.realworld.webservice.data;

import org.realworld.webservice.model.Tags;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class TagsDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    TagsRowMapper tagsRowMapper;

    @Value("${sql.getTags}")
    private String getAllTags;

    public Tags getTags() {
        return jdbcTemplate.queryForObject(getAllTags, tagsRowMapper);
    }
}
