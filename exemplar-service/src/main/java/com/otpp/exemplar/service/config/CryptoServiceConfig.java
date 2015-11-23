package com.otpp.exemplar.service.config;

import com.otpp.crypto.service.manager.CryptoServiceManager;
import com.otpp.exemplar.service.CryptoServiceProxy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

@Configuration
public class CryptoServiceConfig {

    @Value("${ws.crypto.url}")
    private String cryptoServiceUrl;

    @Value("${ws.crypto.username}")
    private String cryptoServiceUsername;

    @Bean
    public CryptoServiceProxy cryptoServiceProxy(){
        return new CryptoServiceProxy();
    }

    @Bean
    public CryptoServiceManager cryptoServiceManager(){
        return CryptoServiceManager.getInstanceForURL(cryptoServiceUrl, cryptoServiceUsername);
    }

}
