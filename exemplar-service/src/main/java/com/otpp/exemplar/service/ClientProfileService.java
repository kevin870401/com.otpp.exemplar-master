package com.otpp.exemplar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.otpp.core.InternalReferenceNumber;
import com.otpp.exemplar.domain.Telephone;
import com.otpp.exemplar.service.finders.TelephoneFinder;

public class ClientProfileService {

    private final TelephoneFinder telephoneFinder;

    @Autowired
    public ClientProfileService(TelephoneFinder telephoneFinder) {
        this.telephoneFinder = telephoneFinder;
    }

    public List<Telephone> getPhones(InternalReferenceNumber irn) {
        return telephoneFinder.findByIrn(irn);
    }

}
