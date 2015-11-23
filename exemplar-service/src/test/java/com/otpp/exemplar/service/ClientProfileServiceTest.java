package com.otpp.exemplar.service;

import static com.otpp.exemplar.service.TestUtils.TEST_IRN;
import static org.assertj.core.api.Assertions.assertThat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import com.otpp.exemplar.db.config.PersistenceConfig;
import com.otpp.exemplar.service.config.ClientProfileConfig;

@ContextConfiguration(classes = {PersistenceConfig.class, ClientProfileConfig.class})
@Test
public class ClientProfileServiceTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private ClientProfileService clientProfileService;

    public void whenGetPhonesForTEST_IRN_expect3Phones() {
        assertThat(clientProfileService.getPhones(TEST_IRN)).isNotEmpty();
    }

}
