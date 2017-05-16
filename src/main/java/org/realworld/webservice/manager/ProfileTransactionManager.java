package org.realworld.webservice.manager;

import org.realworld.webservice.data.ProfileDao;
import org.realworld.webservice.model.Profile;
import org.realworld.webservice.security.JwtUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional(readOnly = true, timeout = 5)
public class ProfileTransactionManager {

    @Autowired
    ProfileDao profileDao;



    public Profile getProfileByUsername(String username) {
        return profileDao.getProfileByUsername(username);
    }

    public Profile getProfileByUsername(String username, JwtUser follower) {//username is email
        Profile profile = profileDao.getProfileByUsername(username);
        profile.getProfile().setFollowing(profileDao.isFollower(username, follower.getEmail()));
        return profile;
    }
}
