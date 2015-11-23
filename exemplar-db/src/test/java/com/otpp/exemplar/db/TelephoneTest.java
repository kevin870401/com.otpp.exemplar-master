package com.otpp.exemplar.db;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import com.otpp.exemplar.db.config.PersistenceConfig;

@ContextConfiguration(classes = PersistenceConfig.class)
public class TelephoneTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private TelephoneRepository telephoneRepository;

    @Test
    public void testRetrieveTelephones() {
        List<Telephone> phones = telephoneRepository.findByIrn("300287364");
        assertThat(phones != null);
        assertThat(phones.size() == 3);
    }

}
