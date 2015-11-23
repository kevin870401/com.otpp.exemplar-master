package com.otpp.exemplar.service.config;

import com.otpp.organization.manager.OrganizationManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrgServiceConfig {

    @Value("${ws.org.url}")
    private String orgServiceUrl;

    @Bean
    public OrganizationManager orgManager() {
        OrganizationManager orgManager = OrganizationManager.getInstance();
        orgManager.initialize(orgServiceUrl);
        return orgManager;
    }

}
