package com.hellospring.controllers;

import com.hellospring.persistence.model.SimpleUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {
    @Autowired
    ApplicationContext context;

    @RequestMapping(value = "/auth")
    public String auth() {
        SimpleUser user = context.getBean("user", SimpleUser.class);
        user.setAuthorized(true);
        return "redirect:/";
    }

    @RequestMapping(value = "/un_auth")
    public String unauth() {
        SimpleUser user = context.getBean("user", SimpleUser.class);
        user.setAuthorized(false);
        return "redirect:/";
    }
}
