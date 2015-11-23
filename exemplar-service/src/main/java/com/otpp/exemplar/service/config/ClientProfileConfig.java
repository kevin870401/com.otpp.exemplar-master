package com.otpp.exemplar.service.config;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.otpp.exemplar.db.TelephoneRepository;
import com.otpp.exemplar.service.ClientProfileService;
import com.otpp.exemplar.service.finders.TelephoneFinder;
import com.otpp.exemplar.service.mappers.TelephoneMapper;

@Configuration
public class ClientProfileConfig {
    
    @Autowired
    private TelephoneRepository telephoneRepository;

    @Bean
    public TelephoneFinder telephoneFinder() {
        return new TelephoneFinder(telephoneRepository, telephoneMapper());
    }

    @Bean
    public TelephoneMapper telephoneMapper() {
        return new TelephoneMapper(defaultMapperFactory());
    }

    @Bean
    public MapperFactory defaultMapperFactory() {
        return new DefaultMapperFactory.Builder().build();
    }

    @Bean
    public ClientProfileService clientProfileService() {
        return new ClientProfileService(telephoneFinder());
    }
}
