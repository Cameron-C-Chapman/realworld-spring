package org.realworld.webservice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.realworld.webservice.model.Tags;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class TagsControllerIntegrationTests {

    @Autowired
    private TestRestTemplate client;

    @Test
    public void getTagsShouldContainListOfTags() {
        ResponseEntity<Tags> response = this.client.getForEntity("/tags", Tags.class);
        Tags result = response.getBody();
        assertThat(result.getTags().size(), is(4));
    }
}
