package com.luv2code.springdemo.mvc;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Customer {

    // add a field for the first name
    private String firstName;

    // add a field for the last name
    @NotNull(message = "Last Name is required")
    @Size(min = 2, message = "Last Name is required")
    private String lastName;

    // getters and setters
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
