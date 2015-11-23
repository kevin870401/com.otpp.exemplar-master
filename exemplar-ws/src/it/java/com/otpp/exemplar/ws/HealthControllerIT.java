package com.otpp.exemplar.ws;

import org.springframework.http.ResponseEntity;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.http.HttpStatus.OK;

@Test(enabled = false)
public class HealthControllerIT extends AbstractControllerIT {

    public void whenGetDependencies_expectOk() throws IOException {
        ResponseEntity<String> response = getResponseEntityString("/dependencies");
        assertThat(response.getStatusCode()).isEqualTo(OK);
    }
}
