package com.practise;

import org.junit.Assert;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.builder.*;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import practise.model.Customer;


public class RulesTest {
    static final Logger LOG = LoggerFactory.getLogger(RulesTest.class);
    private KieServices kieServices = KieServices.Factory.get();


   @Test
    public void test() {
        ReleaseId releaseId = kieServices.newReleaseId("practise", "rules", "1.0-SNAPSHOT");

        KieContainer kieContainer = kieServices.newKieContainer(releaseId);

        KieSession kieSession = kieContainer.newKieSession("ksession-rule");

        Assert.assertNotNull(kieSession);

        Customer  c1 =  new Customer(15, 0);
        Customer  c2 =  new Customer(25 , 0);

        kieSession.insert(c1);
        kieSession.fireAllRules();

        System.err.println(c1.toString());

        kieSession.insert(c2);
        kieSession.fireAllRules();

       System.err.println(c2.toString());

    }


}