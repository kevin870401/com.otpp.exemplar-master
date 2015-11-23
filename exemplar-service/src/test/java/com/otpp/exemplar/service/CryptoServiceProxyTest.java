package com.otpp.exemplar.service;

import com.otpp.crypto.service.manager.CryptoServiceManager;
import org.apache.commons.lang3.StringUtils;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.util.reflection.Whitebox;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.otpp.exemplar.service.TestUtils.TEST_IRN;
import static org.assertj.core.api.Assertions.assertThat;

@Test
public class CryptoServiceProxyTest {

    private CryptoServiceProxy cryptoService;

    @Mock
    private CryptoServiceManager cryptoServiceManager;

    @BeforeTest
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        cryptoService = new CryptoServiceProxy();
        Whitebox.setInternalState(cryptoService, "cryptoManager", cryptoServiceManager);
    }

    public void whenEncryptBankAccountForTEST_IRN_expectSuccess() {
        String input = "bankaccount";
        byte[] expected = "this should be an encrypted account".getBytes();

        Mockito.when(cryptoServiceManager.encrypt("BankAccount", TEST_IRN.toString(), StringUtils.rightPad(input, CryptoServiceProxy.FIELD_LENGTH_BANKACCOUNT))).thenReturn(expected);
        assertThat(cryptoService.encryptBankAccount(TEST_IRN, input)).isEqualTo(expected);
    }

    public void whenDecryptBankAccountForTEST_IRN_expectSuccess() {
        byte[] input = "any encrypted account".getBytes();
        String expected = "bankaccount";

        Mockito.when(cryptoServiceManager.decrypt("BankAccount", TEST_IRN.toString(), input)).thenReturn(expected);
        assertThat(cryptoService.decryptBankAccount(TEST_IRN, input)).isEqualTo(expected);
    }
}
