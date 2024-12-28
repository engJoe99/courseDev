package com.luv2code.springboot.crudops.service;

import com.luv2code.springboot.crudops.dao.EmployeeRepository;
import com.luv2code.springboot.crudops.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    // define a field for the dao
    //private EmployeeDAO employeeDAO;
    private EmployeeRepository employeeRepository;

    // inject the employeeRepository using constructor injection
    @Autowired
    public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
        employeeRepository = theEmployeeRepository;
    }



    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> findById(int theId) {
        return employeeRepository.findById(theId);
    }


    @Override
    public Employee save(Employee theEmployee) {
        return employeeRepository.save(theEmployee);
    }

    @Override
    public void deleteById(int theId) {
        employeeRepository.deleteById(theId);
    }
}
