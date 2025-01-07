package com.luv2code.springboot.thymeleafdemo.controller;


import com.luv2code.springboot.thymeleafdemo.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {

    // add a new field for countries saved in application.properties
    @Value("${countries}")
    private List<String> countries;

    // add a new field for programming languages saved in application.properties
    @Value("${languages}")
    private List<String> languages;

    // add a new field for OSs saved in application.properties
    @Value("${operatingSystems}")
    private List<String> operatingSystems;

    // define a method to show the initial HTML form
    @GetMapping("/showStudentForm")
    public String showForm(Model model) {
        // create a student object
        Student theStudent = new Student();

        // add theStudent to the model
        model.addAttribute("student", theStudent);

        // add the list of countries to the model
        model.addAttribute("countries", countries);

        // add the list of programming languages to the model
        model.addAttribute("languages", languages);

        // add the list of operating systems to the model
        model.addAttribute("systems", operatingSystems);

        return "student-form";
    }


    // define a method to process the HTML form
    @PostMapping("/processStudentForm")
    public String processForm(@ModelAttribute("student") Student theStudent) {
        // log the input data
        System.out.println("The Student: " +
                theStudent.getFirstName() + " " +
                theStudent.getLastName()) ;

        return "student-confirmation";
    }




}
