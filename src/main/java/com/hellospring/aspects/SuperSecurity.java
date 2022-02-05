package com.hellospring.aspects;

import com.hellospring.persistence.model.SimpleUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

public class SuperSecurity {
    @Autowired
    ApplicationContext applicationContext;

    public void checkAuth()  {
        SimpleUser user = applicationContext.getBean("user",SimpleUser.class);
        if(!user.isAuthorized()){
            throw new RuntimeException();
        }
    }
}
