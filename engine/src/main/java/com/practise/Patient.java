package com.practise;

import lombok.Builder;
import lombok.Data;
import org.drools.compiler.kie.builder.impl.KieServicesImpl;
import org.kie.api.KieServices;
import org.kie.api.builder.*;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;
import org.kie.internal.io.ResourceFactory;

import java.io.File;

@Data
@Builder
public class Patient {

    private String name;
    private int age;
    private String city;
    private boolean eligibleForClaim;


}
