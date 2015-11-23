package com.otpp.exemplar.service.mappers;

import ma.glasnost.orika.MapperFactory;

import org.springframework.beans.factory.annotation.Autowired;

public class TelephoneMapper extends DefaultMapper<com.otpp.exemplar.domain.Telephone, com.otpp.exemplar.db.Telephone> {

    @Autowired
    public TelephoneMapper(MapperFactory mapperFactory) {
        super(mapperFactory);
    }

    @Override
    protected Class<com.otpp.exemplar.db.Telephone> dbClass() {
        return com.otpp.exemplar.db.Telephone.class;
    }

    @Override
    protected Class<com.otpp.exemplar.domain.Telephone> domainClass() {
        return com.otpp.exemplar.domain.Telephone.class;
    }

}
