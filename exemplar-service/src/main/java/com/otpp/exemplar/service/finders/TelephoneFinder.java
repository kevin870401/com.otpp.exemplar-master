package com.otpp.exemplar.service.finders;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.otpp.core.InternalReferenceNumber;
import com.otpp.exemplar.db.TelephoneRepository;
import com.otpp.exemplar.domain.Telephone;
import com.otpp.exemplar.service.mappers.TelephoneMapper;

public class TelephoneFinder {

    private final TelephoneRepository telephoneRepository;

    private final TelephoneMapper telephoneMapper;

    @Autowired
    public TelephoneFinder(TelephoneRepository telephoneRepository, TelephoneMapper telephoneMapper) {
        this.telephoneRepository = telephoneRepository;
        this.telephoneMapper = telephoneMapper;
    }

    public List<Telephone> findByIrn(InternalReferenceNumber irn) {
        List<com.otpp.exemplar.db.Telephone> dbPhones = telephoneRepository.findByIrn(irn.toString());
        return telephoneMapper.mapDbToDomain(dbPhones);
    }
}
