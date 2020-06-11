package com.practise;

import org.kie.api.KieServices;
import org.kie.api.builder.KieScanner;
import org.kie.api.builder.ReleaseId;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class Config {

    private KieServices kieServices = KieServices.Factory.get();

    int pollingInterval = 60 * 1000; // ms

    @Autowired
    Environment environment;


    @Bean
    public KieSession kieSession() {
        KieContainer kieContainer = kieServices.newKieContainer(releaseId());

        KieScanner kieScanner = kieServices.newKieScanner(kieContainer);
        kieScanner.start(pollingInterval);
        return kieContainer.newKieSession("ksession-rule");
    }


    private ReleaseId releaseId() {
        return kieServices.newReleaseId("practise", "rules", "1.0-SNAPSHOT");
    }


}
