package com.kv.demo.jackson.demo.model;

import java.io.Serial;
import java.io.Serializable;

public class WriteDemoDORes implements Serializable {

    @Serial
    private static final long serialVersionUID = -7421195565864350182L;

    private String firstName;

    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
