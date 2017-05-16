package org.realworld.webservice;

import org.junit.Test;
import org.realworld.webservice.model.Profile;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


public class ProfileControllerIntegrationTests extends AbstractAuthEnabledIntegrationTest {

    @Test
    public void getProfileByUsernameUnauthenticated() {
        ResponseEntity<Profile> response = client.exchange(getUrl("/api/profiles/{username}"),
                HttpMethod.GET,
                null,
                Profile.class,
                "user1"
        );
        Profile result = response.getBody();
        assertThat(result.getProfile().getUsername(), is("user1"));
        assertThat(result.getProfile().getFollowing(), is(false));
    }

    @Test
    public void getProfileByUsernameFromFollower() {
        ResponseEntity<Profile> response = client.exchange(getUrl("/api/profiles/{username}"),
                HttpMethod.GET,
                new HttpEntity<>(getTokenHeaders()),
                Profile.class,
                "user2"
        );
        Profile result = response.getBody();
        assertThat(result.getProfile().getUsername(), is("user2"));
        assertThat(result.getProfile().getFollowing(), is(true));
    }
}
