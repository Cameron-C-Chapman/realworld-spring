package org.realworld.webservice.data;

import org.realworld.webservice.model.User;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class AuthorRowMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User author = new User();
        author.setUsername(rs.getString("username"));
        author.setBio(rs.getString("bio"));
        author.setImage(rs.getString("image"));
        return author;
    }

}