package com.otpp.exemplar.ws;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class AbstractControllerIT {

    RestTemplate restTemplate = new RestTemplate();

    private String baseUrl = "http://devservices/exemplarSnapshot";

    String url(String requestUrl) {
        return baseUrl + requestUrl;
    }

    ResponseEntity<String> getResponseEntityString(String requestUrl) {
        return restTemplate.getForEntity(url(requestUrl), String.class);
    }
}
