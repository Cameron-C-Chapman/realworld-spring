package org.realworld.webservice;

import org.json.JSONException;
import org.junit.Before;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public abstract class AbstractAuthEnabledIntegrationTest extends AbstractIntegrationTest {

    private String token;

    @Before()
    public void performAuthentication() throws JSONException {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("X-Requested-With", "XMLHttpRequest");

        ResponseEntity<Map> result = client.exchange("http://localhost:" + this.port + "/users/login", HttpMethod.POST, new HttpEntity<>("{\"user\":{\"email\":\"user1@mail.com\", \"password\":\"password\"}}",
                headers), Map.class);
        this.token = result.getBody().get("token").toString();
    }

    public String getToken() {
        return token;
    }

    public HttpHeaders getTokenHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("X-Requested-With", "XMLHttpRequest");
        headers.add("Authorization", "Token " + this.getToken());
        return headers;
    }
}
