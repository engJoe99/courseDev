package com.luv2code.springdemo.mvc;

import jakarta.validation.constraints.*;

public class Customer {

    // add a field for the first name
    private String firstName;

    // add a field for the last name
    @NotNull(message = "Last Name is required")
    @Size(min = 2, message = "Last Name is required")
    private String lastName;

    // add a field for the free passes
    @NotNull(message = "is required")
    @Min(value = 0, message = "Free passes must be greater than or equal to zero")
    @Max(value = 10, message = "Free passes must be less than or equal to 10")
    private Integer freePasses;

    // add a field for the postal code
    @Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "Postal code must be 5 chars/digits")
    private String postalCode;

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

    public Integer getFreePasses() {
        return freePasses;
    }

    public void setFreePasses(Integer freePasses) {
        this.freePasses = freePasses;
    }
    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }


}
