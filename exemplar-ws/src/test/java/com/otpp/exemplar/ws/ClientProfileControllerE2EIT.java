package com.otpp.exemplar.ws;

import com.fasterxml.jackson.core.type.TypeReference;
import com.otpp.exemplar.domain.Telephone;
import org.springframework.http.ResponseEntity;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.http.HttpStatus.OK;

@Test
public class ClientProfileControllerE2EIT extends AbstractControllerE2EIT {

    public void whenGetPhones_expectOk() throws IOException {
        String testIrn = "300287364";

        ResponseEntity<String> response = getResponseEntityString("/" + testIrn + "/phones");
        assertThat(response.getStatusCode()).isEqualTo(OK);
        Map<String, List<Telephone>> actual = mapper.readValue(response.getBody(), new TypeReference<Map<String, List<Telephone>>>() {

        });

        List<Telephone> actualPhones = actual.get("phones");
        assertThat(actualPhones).isNotEmpty();
        for (Telephone phone : actualPhones) {
            assertThat(phone.getEntityIrn().equals(testIrn));
        }
    }

    public void whenBankAccount_expectOk() throws IOException {
        ResponseEntity<String> response = getResponseEntityString("/abc/bank-account/xyz");
        assertThat(response.getStatusCode()).isEqualTo(OK);

    }
}
