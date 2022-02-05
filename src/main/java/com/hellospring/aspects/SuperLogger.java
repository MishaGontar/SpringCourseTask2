package com.hellospring.aspects;

import com.hellospring.persistence.model.SimpleUser;
import org.aspectj.lang.JoinPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import java.util.Objects;

import static java.lang.System.out;

public class SuperLogger {
    @Autowired
    private ApplicationContext applicationContext;

    public void beforeMethod (JoinPoint joinPoint){
        SimpleUser user = applicationContext.getBean("user",SimpleUser.class);
        out.println("Is Authorized : " + user.isAuthorized());
        out.println("******");
        out.println("Log : before method " + joinPoint.getSignature().toShortString());
    }

    public void afterReturn (JoinPoint joinPoint , Objects result){
        out.println(joinPoint.getSignature().getName() + " method of " + joinPoint.getTarget().toString() + " was invoked!");
        out.println("Result of method execution : " + result);
        out.println("***********************************");
        out.println("* Log : success method invocation *");
        out.println("***********************************");
    }

    public void afterThrowing(Exception exception){
        out.println("Log : HELLO ERROR! ");
        out.println("Exception : " + exception.getMessage());

    }
}
