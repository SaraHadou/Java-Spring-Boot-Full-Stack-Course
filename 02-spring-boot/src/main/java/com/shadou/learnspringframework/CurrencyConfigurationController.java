package com.shadou.learnspringframework;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyConfigurationController {

    @Autowired
    private CurrencyConfigurationService currencyConfigurationService;

    @RequestMapping("currency-configuration/")
    public CurrencyConfigurationService retrieveAllCourses() {
        return currencyConfigurationService;
    }

}
