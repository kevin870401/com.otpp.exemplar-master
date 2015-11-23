package service;

import com.otpp.core.InternalReferenceNumber;
import com.otpp.exemplar.service.CryptoServiceProxy;
import com.otpp.exemplar.ws.ExemplarApp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

@SpringApplicationConfiguration(classes = ExemplarApp.class)
@Test
@ActiveProfiles(profiles = "dev")
public class CryptoServiceProxyIT extends AbstractTestNGSpringContextTests {

    @Autowired
    private CryptoServiceProxy cryptoService;

    public void whenEncryptAndDecryptBankAccount_expectMatch() {
        InternalReferenceNumber irn = InternalReferenceNumber.valueOf("does not matter");
        String bankAccount = "whatever";

        byte[] encrypted = cryptoService.encryptBankAccount(irn, bankAccount);
        assertThat(cryptoService.decryptBankAccount(irn, encrypted)).isEqualTo(bankAccount);
    }
}
