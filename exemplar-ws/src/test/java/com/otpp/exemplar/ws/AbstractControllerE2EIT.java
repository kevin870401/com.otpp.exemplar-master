package com.otpp.exemplar.ws;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringApplicationConfiguration(classes = ExemplarApp.class)
@WebIntegrationTest("server.port:0")
@ActiveProfiles(profiles="dev")
public class AbstractControllerE2EIT extends AbstractTestNGSpringContextTests {

    private final RestTemplate restTemplate = new TestRestTemplate();
    final ObjectMapper mapper = new ObjectMapper();

    @Value("${local.server.port}")
    int port;

    @Value("${server.context-path}")
    String contextRoot;

    private String baseUrl;

    @PostConstruct
    public void init() {
        baseUrl = "http://localhost:" + port + contextRoot;
    }

    String url(String requestUrl) {
        return baseUrl + requestUrl;
    }

    ResponseEntity<String> getResponseEntityString(String requestUrl) {
        return restTemplate.getForEntity(url(requestUrl), String.class);
    }
}
