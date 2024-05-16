package com.shadou.springboot.myWebApp.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    private AuthenticationService authenticationService;

    private Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping(value="login", method=RequestMethod.GET)
    public String goToLoginPage() {

//        logger.debug("Request param is {}", name);
//        logger.info("Printed at info level.");
//        logger.warn("Printed at warn level.");

        return "login";
    }

    @RequestMapping(value="login", method=RequestMethod.POST)
    public String goToWelcomePage(@RequestParam String name,
                                  @RequestParam String password,
                                  ModelMap modelMap) {
        if (authenticationService.authenticate(name, password)) {
            modelMap.put("name", name);
            return "welcome";
        }
        modelMap.put("errorMessage", "Invalid Credentials! Please try again");
        return "login";
    }


}
