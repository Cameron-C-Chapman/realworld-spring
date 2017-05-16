package org.realworld.webservice.controller;


import org.realworld.webservice.manager.ProfileTransactionManager;
import org.realworld.webservice.model.Profile;
import org.realworld.webservice.model.User;
import org.realworld.webservice.model.UserProfile;
import org.realworld.webservice.security.JwtUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/profiles")
public class ProfileController {

    private final ProfileTransactionManager profileTransactionManager;

    @Autowired
    public ProfileController(ProfileTransactionManager profileTransactionManager) {
        this.profileTransactionManager = profileTransactionManager;
    }

    @RequestMapping("/{username}")
    public Profile getProfileByUsername(@PathVariable("username") String username, @AuthenticationPrincipal JwtUser follower) {
        return Optional.ofNullable(follower)
                .map((u) -> this.profileTransactionManager.getProfileByUsername(username, u))
                .orElse(this.profileTransactionManager.getProfileByUsername(username));
    }
}
