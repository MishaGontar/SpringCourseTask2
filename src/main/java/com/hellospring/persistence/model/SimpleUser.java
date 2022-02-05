package com.hellospring.persistence.model;

import lombok.Data;

@Data
public class SimpleUser {
    private boolean authorized;

    public void setAuth(boolean auth){this.authorized = auth;}
}
