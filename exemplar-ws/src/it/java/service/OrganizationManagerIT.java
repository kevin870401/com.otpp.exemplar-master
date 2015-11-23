package service;

import com.otpp.core.InternalReferenceNumber;
import com.otpp.exemplar.ws.ExemplarApp;
import com.otpp.organization.manager.OrganizationManager;
import com.otpp.organization.manager.ws.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

@SpringApplicationConfiguration(classes = ExemplarApp.class)
@Test
@ActiveProfiles(profiles = "dev")
public class OrganizationManagerIT extends AbstractTestNGSpringContextTests {

    @Autowired
    private OrganizationManager orgManager;

    public void whenGetOrgByIrn_expectNameMatch() {
        Organization org = orgManager.getOrgByIrn(InternalReferenceNumber.valueOf("305634739"));
        assertThat(org.getName()).isEqualTo("NATIONAL WESTMINISTER BANK");
    }
}
