package org.realworld.webservice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.realworld.webservice.model.Profile;
import org.realworld.webservice.model.Tags;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


public class ProfileControllerIntegrationTests extends AbstractAuthEnabledIntegrationTest {


    @Test
    public void getProfileByUsernameUnauthenticated() {
        ResponseEntity<Profile> response = client.exchange("http://localhost:"+this.port+"/api/profiles/{username}",
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
        ResponseEntity<Profile> response = client.exchange("http://localhost:"+this.port+"/api/profiles/{username}",
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
