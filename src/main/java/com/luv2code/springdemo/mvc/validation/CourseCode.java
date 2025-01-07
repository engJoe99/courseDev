package com.luv2code.springdemo.mvc.validation;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CourseCodeConstraintValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {

    // define default course code
    public String value() default "LUV";

    // define default error message
    public String message() default "must start with LUV";

    // define default group ==> Groups can group related constraints
    // This code defines a method named groups that returns an array of Class objects.
    // It has a default value of an empty array, indicating that no specific groups are required unless specified otherwise.
    public Class<?>[] groups() default {};

    // define default payload ==> Provide custom details about validation failure (Severity level, error code)
    // This code defines a method named payload that returns an array of Class objects.
    // It has a default value of an empty array, indicating that it can be used to specify
    // a list of classes as part of an annotation in Java.
    public Class<? extends Payload>[] payload() default {};

}
