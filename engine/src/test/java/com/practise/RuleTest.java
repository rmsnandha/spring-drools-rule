package com.practise;

import org.drools.decisiontable.DecisionTableProviderImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.builder.*;
import org.kie.api.io.Resource;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.internal.io.ResourceFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;


public class RuleTest {
    static final Logger LOG = LoggerFactory.getLogger(RuleTest.class);
    private KieServices kieServices = KieServices.Factory.get();


    @Test
    public void test() {
        ReleaseId releaseId = kieServices.newReleaseId("practise", "rule-assets", "1.0-SNAPSHOT");

        KieContainer kieContainer = kieServices.newKieContainer(releaseId);

        KieSession kieSession = kieContainer.newKieSession("ksession-rule");

        Assert.assertNotNull(kieSession);
    }


}