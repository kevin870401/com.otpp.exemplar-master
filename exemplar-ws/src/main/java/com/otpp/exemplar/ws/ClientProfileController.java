package com.otpp.exemplar.ws;

import com.google.common.collect.ImmutableMap;
import com.otpp.core.InternalReferenceNumber;
import com.otpp.exemplar.service.ClientProfileService;
import com.otpp.exemplar.service.CryptoServiceProxy;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;

import static com.otpp.exemplar.ws.ControllerUtils.ok;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class ClientProfileController {

    @Inject
    private ClientProfileService profileService;

    @Inject
    private CryptoServiceProxy cryptoService;

    @RequestMapping(value = "/{irn}/phones", method = GET)
    @ResponseBody
    public ResponseEntity<?> getPhones(@PathVariable InternalReferenceNumber irn) {
        return ok("phones", profileService.getPhones(irn));
    }

    @RequestMapping(value = "/{irn}/bank-account/{account}", method = GET)
    @ResponseBody
    public ResponseEntity<?> bankAccount(@PathVariable InternalReferenceNumber irn, @PathVariable String account) {
        byte[] encrypted = cryptoService.encryptBankAccount(irn, account);
        return ok("account", ImmutableMap.of("encrypted", new String(encrypted), "decrypted", cryptoService.decryptBankAccount(irn, encrypted)));
    }
}
