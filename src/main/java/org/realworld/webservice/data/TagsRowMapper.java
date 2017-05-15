package org.realworld.webservice.data;

import org.realworld.webservice.model.Tags;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class TagsRowMapper implements RowMapper<Tags> {

    @Override
    public Tags mapRow(ResultSet rs, int rowNum) throws SQLException {
        Tags tags = new Tags();
        tags.addTag(rs.getString("tag"));
        while (rs.next()) {
            tags.addTag(rs.getString("tag"));
        }
        return tags;
    }
}
