package com.practise;

import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {


    @Autowired
    KieSession kieSession;

    @PostMapping("/patient")
    public Patient orderNow(@RequestBody Patient patient) {

        System.err.println(kieSession.toString());

        return patient;
    }

}
