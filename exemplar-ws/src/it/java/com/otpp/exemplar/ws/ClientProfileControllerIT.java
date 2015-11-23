package com.otpp.exemplar.ws;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.http.HttpStatus.OK;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Test(enabled = false)
public class ClientProfileControllerIT extends AbstractControllerIT {

    public void whenGetPhones_expectOk() throws JsonParseException,
            JsonMappingException, IOException {
        ResponseEntity<String> response = getResponseEntityString("/abc/phones");
        assertThat(response.getStatusCode()).isEqualTo(OK);
        //TODO verify the deserialization
    }
}
