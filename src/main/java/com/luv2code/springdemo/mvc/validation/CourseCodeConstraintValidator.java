package com.luv2code.springdemo.mvc.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {

    // define a private field to hold the course prefix
    private String coursePrefix;


    // This method initializes the coursePrefix variable with the value from the CourseCode annotation.
    // It is typically used in custom validation for course codes in a Java application.
    @Override
    public void initialize(CourseCode theCourseCode) {
        coursePrefix = theCourseCode.value();
    }

    // This method validates if the provided course code starts with a specified prefix.
    // It returns true if the code is valid, otherwise false.
    @Override
    public boolean isValid(String theCode, ConstraintValidatorContext constraintValidatorContext) {

        boolean result;
        if (theCode != null) {
            result = theCode.startsWith(coursePrefix);
        }
        else {
            result = false;
        }
        return result;
    }


}
