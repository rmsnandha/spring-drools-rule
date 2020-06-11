package com.practise;

import org.kie.api.KieServices;
import org.kie.api.builder.ReleaseId;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class DroolConfig {

    private KieServices kieServices = KieServices.Factory.get();

    @Autowired
    Environment environment;


    @Bean
    public KieSession kieSession() {
        KieContainer kieContainer = kieServices.newKieContainer(releaseId());
        return kieContainer.newKieSession("ksession-rule");
    }


    private ReleaseId releaseId() {
        return kieServices.newReleaseId("practise", "rule-assets", "1.0-SNAPSHOT");
    }

}
