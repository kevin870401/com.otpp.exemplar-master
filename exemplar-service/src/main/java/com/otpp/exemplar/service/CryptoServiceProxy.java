package com.otpp.exemplar.service;

import com.otpp.core.InternalReferenceNumber;
import com.otpp.crypto.service.manager.CryptoServiceManager;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

public class CryptoServiceProxy {

    public static final String BANK_ACCOUNT_FIELD_NAME = "BankAccount";
    public static final int FIELD_LENGTH_BANKACCOUNT = 21;

    @Autowired
    private CryptoServiceManager cryptoManager;

    public byte[] encryptBankAccount(InternalReferenceNumber irn, String account){
        return cryptoManager.encrypt(BANK_ACCOUNT_FIELD_NAME, irn.toString(), StringUtils.rightPad(account, FIELD_LENGTH_BANKACCOUNT));
    }

    public String decryptBankAccount(InternalReferenceNumber irn, byte[] account){
        return cryptoManager.decrypt(BANK_ACCOUNT_FIELD_NAME, irn.toString(), account).trim();
    }
}
