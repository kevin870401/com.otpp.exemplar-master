package com.otpp.exemplar.service.config;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;

import com.otpp.exemplar.service.config.ClientProfileConfig;

@Test
public class ClientProfileConfigTest {

    public void whenGetGervice_expectNotNull() {
        ClientProfileConfig config = new ClientProfileConfig();
        assertThat(config.clientProfileService()).isNotNull();
    }
}
