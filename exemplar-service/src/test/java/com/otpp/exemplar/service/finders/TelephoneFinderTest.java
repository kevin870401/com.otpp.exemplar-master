package com.otpp.exemplar.service.finders;

import static com.otpp.exemplar.service.TestUtils.TEST_IRN;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import com.otpp.exemplar.db.config.PersistenceConfig;
import com.otpp.exemplar.domain.Telephone;
import com.otpp.exemplar.service.config.ClientProfileConfig;

@ContextConfiguration(classes = {PersistenceConfig.class, ClientProfileConfig.class})
public class TelephoneFinderTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private TelephoneFinder telephoneFinder;

    @Test
    public void whenFindByIrn300287364_Expect3Telephones() {
        List<Telephone> phones = telephoneFinder.findByIrn(TEST_IRN);
        assertThat(phones != null);
        assertThat(phones).isNotEmpty();
    }
}
