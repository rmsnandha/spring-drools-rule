package com.practise;

import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import practise.model.Customer;

@RestController
public class Controller {


    @Autowired
    KieSession kieSession;

    @PostMapping("/offer")
    public Customer orderNow(@RequestBody Customer customer) {

        FactHandle insert = kieSession.insert(customer);
        int i = kieSession.fireAllRules();

        return customer;
    }

}
