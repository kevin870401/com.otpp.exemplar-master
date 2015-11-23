package com.otpp.exemplar.service.mappers;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import com.otpp.exemplar.db.config.PersistenceConfig;
import com.otpp.exemplar.service.config.ClientProfileConfig;

@Test
@ContextConfiguration(classes = {PersistenceConfig.class, ClientProfileConfig.class})
@ActiveProfiles("test")
/*
 * Note how there are two methods that have very similar implementation. Java's limitations make it difficult to extract the common code.
 * The two object types that have the same method names are of (purposely) different hierarchies and trying to apply the DRY principle would 
 * result in some ugly Java code. Instead, we've chosen to use the DAMP principle.
 */
public class TelephoneMapperTest extends AbstractTestNGSpringContextTests {

    static final String AREA_CODE = "416";
    static final String COMMENT = "Nuts and gum together at last!";
    static final String COUNTRY = "Kazakstan";
    static final String ENTITY_IRN = "123456789";
    static final String EXTENSION = "666";
    static final String NUMBER = "12345678";
    static final String ROUTING = "123 Fake Routing";
    static final String TYPE = "HM1";

    @Autowired
    private TelephoneMapper telephoneMapper;

    public void whenMapDbToDomainWithAllFieldsByReference_ExpectAllFieldsToBeCopied() {
        com.otpp.exemplar.db.Telephone dbPhone = createDbTelephone();

        com.otpp.exemplar.domain.Telephone domainPhone = telephoneMapper.mapDbToDomain(dbPhone);
        domainObjectAsserts(domainPhone);
    }

    public void whenMapDomainToDbWithAllFieldsByReference_ExpectAllFieldsToBeCopied() {
        com.otpp.exemplar.domain.Telephone domainPhone = createDomainTelephone();

        com.otpp.exemplar.db.Telephone dbPhone = telephoneMapper.mapDomainToDb(domainPhone);
        dbObjectAsserts(dbPhone);
    }
    
    public void whenMapDbToDomainAsListWithAllFieldsByReference_ExpectAllFieldsToBeCopied() {
        com.otpp.exemplar.db.Telephone dbPhone = createDbTelephone();
        List<com.otpp.exemplar.db.Telephone> dbPhones = new ArrayList<com.otpp.exemplar.db.Telephone>();
        dbPhones.add(dbPhone);

        List<com.otpp.exemplar.domain.Telephone> domainPhones = telephoneMapper.mapDbToDomain(dbPhones);
        assertThat(domainPhones.size() == 1);
        
        com.otpp.exemplar.domain.Telephone domainPhone = domainPhones.get(0);
        domainObjectAsserts(domainPhone);
    }
    
    public void whenMapDomainToDbAsListWithAllFieldsByReference_ExpectAllFieldsToBeCopied() {
        com.otpp.exemplar.domain.Telephone domainPhone = createDomainTelephone();
        List<com.otpp.exemplar.domain.Telephone> domainPhones = new ArrayList<com.otpp.exemplar.domain.Telephone>();
        domainPhones.add(domainPhone);

        List<com.otpp.exemplar.db.Telephone> dbPhones = telephoneMapper.mapDomainToDb(domainPhones);
        assertThat(dbPhones.size() == 1);
        
        com.otpp.exemplar.db.Telephone dbPhone = dbPhones.get(0);
        dbObjectAsserts(dbPhone);
    }

    private void dbObjectAsserts(com.otpp.exemplar.db.Telephone dbPhone) {
        assertThat(dbPhone != null);
        assertThat(dbPhone.getAreaCode().equals(AREA_CODE));
        assertThat(dbPhone.getComment().equals(COMMENT));
        assertThat(dbPhone.getCountry().equals(COUNTRY));
        assertThat(dbPhone.getEntityIrn().equals(ENTITY_IRN));
        assertThat(dbPhone.getExtension().equals(EXTENSION));
        assertThat(dbPhone.getNumber().equals(NUMBER));
        assertThat(dbPhone.getRouting().equals(ROUTING));
        assertThat(dbPhone.getType().equals(TYPE));
    }

    private void domainObjectAsserts(com.otpp.exemplar.domain.Telephone domainPhone) {
        assertThat(domainPhone != null);
        assertThat(domainPhone.getAreaCode().equals(AREA_CODE));
        assertThat(domainPhone.getComment().equals(COMMENT));
        assertThat(domainPhone.getCountry().equals(COUNTRY));
        assertThat(domainPhone.getEntityIrn().equals(ENTITY_IRN));
        assertThat(domainPhone.getExtension().equals(EXTENSION));
        assertThat(domainPhone.getNumber().equals(NUMBER));
        assertThat(domainPhone.getRouting() == null);
        assertThat(domainPhone.getType().equals(TYPE));
    }

    private com.otpp.exemplar.db.Telephone createDbTelephone() {
        com.otpp.exemplar.db.Telephone dbPhone = new com.otpp.exemplar.db.Telephone();
        dbPhone.setAreaCode(AREA_CODE);
        dbPhone.setComment(COMMENT);
        dbPhone.setCountry(COUNTRY);
        dbPhone.setEntityIrn(ENTITY_IRN);
        dbPhone.setExtension(EXTENSION);
        dbPhone.setNumber(NUMBER);
        dbPhone.setRouting(null); // does it handle null correctly?
        dbPhone.setType(TYPE);
        return dbPhone;
    }

    private com.otpp.exemplar.domain.Telephone createDomainTelephone() {
        com.otpp.exemplar.domain.Telephone domainPhone = new com.otpp.exemplar.domain.Telephone();
        domainPhone.setAreaCode(AREA_CODE);
        domainPhone.setComment(COMMENT);
        domainPhone.setCountry(COUNTRY);
        domainPhone.setEntityIrn(ENTITY_IRN);
        domainPhone.setExtension(EXTENSION);
        domainPhone.setNumber(NUMBER);
        domainPhone.setRouting(ROUTING);
        domainPhone.setType(TYPE);
        return domainPhone;
    }

}
