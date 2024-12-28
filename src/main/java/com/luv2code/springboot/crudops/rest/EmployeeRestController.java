package com.luv2code.springboot.crudops.rest;



import com.luv2code.springboot.crudops.entity.Employee;
import com.luv2code.springboot.crudops.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    // define a filed for theEmployeeService
    private EmployeeService employeeService;

    // inject the EmployeeService using constructor injection
    @Autowired
    public EmployeeRestController(EmployeeService theEmployeeService) {
        employeeService = theEmployeeService;
    }

    // add mapping for GET /employees -- return the list of employees
    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }


    // add mapping for GET /employees/{employeeId} -- return the employee by ID
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId) {
        Employee theEmployee = employeeService.findById(employeeId);

        if (theEmployee == null) {
            throw new RuntimeException("Employee id not found - " + employeeId);
        }

        return theEmployee;
    }


    // add mapping for POST /employees - add new employee
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee) {

        // also just in case they pass an id in JSON ... set id to 0
        // this is to force save of new item ... instead of update

        theEmployee.setId(0);
        Employee dbEmployee = employeeService.save(theEmployee);

        return theEmployee;
    }

    // add mapping for PUT /employees - update existing employee
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee) {

        Employee dbEmployee = employeeService.save(theEmployee);
        return theEmployee;
    }

    // add mapping for DELETE "/employees/{employeeId}" - delete employee
    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId) {
        Employee tempEmployee = employeeService.findById(employeeId);
        // throw exception if employee not found
        if (tempEmployee == null)
            throw new RuntimeException("Employee id not found - " + employeeId);

        employeeService.deleteById(employeeId);
        return "Deleted employee id - " + employeeId;
    }


}
