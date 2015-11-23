package com.otpp.exemplar.ws;

import org.springframework.http.ResponseEntity;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.http.HttpStatus.OK;

@Test
public class HealthControllerE2EIT extends AbstractControllerE2EIT {

    public void whenGetVersion_expectOk() throws IOException {
        ResponseEntity<String> response = getResponseEntityString("/version");
        assertThat(response.getStatusCode()).isEqualTo(OK);
    }

    public void whenGetDependencies_expectOk() throws IOException {
        ResponseEntity<String> response = getResponseEntityString("/dependencies");
        assertThat(response.getStatusCode()).isEqualTo(OK);
    }
}
