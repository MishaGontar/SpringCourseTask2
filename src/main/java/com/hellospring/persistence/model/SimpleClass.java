package com.hellospring.persistence.model;

import lombok.Data;

@Data
public class SimpleClass {
    private String name;
    private int age;

    public static boolean isOlder(SimpleClass s1 , SimpleClass s2){
        return s1.getAge() > s1.getAge();
    }
}
