package org.realworld.webservice.data;

import org.realworld.webservice.model.Profile;
import org.realworld.webservice.model.UserProfile;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class ProfileRowMapper implements RowMapper<Profile> {

    @Override
    public Profile mapRow(ResultSet rs, int rowNum) throws SQLException {
        Profile profile = new Profile();
        UserProfile userProfile = new UserProfile();
        userProfile.setUsername(rs.getString("username"));
        userProfile.setBio(rs.getString("bio"));
        userProfile.setImage(rs.getString("image"));
        userProfile.setFollowing(false);
        profile.setProfile(userProfile);
        return profile;
    }
}
