package com.vburcovschi.spring.rest.controller;

import com.vburcovschi.spring.rest.entity.Employee;
import com.vburcovschi.spring.rest.exception_handling.EmployeeIncorrectData;
import com.vburcovschi.spring.rest.exception_handling.NoSuchEmployeeException;
import com.vburcovschi.spring.rest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRestController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> showAllEmployees(){
        return employeeService.getAllEmployee();
    }
    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id){
        Employee employee = employeeService.getEmployee(id);
        if (employee==null){
            throw new NoSuchEmployeeException("There is no employee with ID = "+id+" in database");
        }
        return employee;
    }

    @PostMapping("/employees")
    public Employee addNewEmployee(@RequestBody Employee employee){
        employeeService.saveEmployee(employee);
        return employee;
    }
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        employeeService.saveEmployee(employee);
        return employee;
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id){
        Employee employee = employeeService.getEmployee(id);
        if (employee==null){
            throw new NoSuchEmployeeException("There is no employee with ID = "+id+" in database");
        }
        employeeService.removeEmployee(id);
        return "Employee with id= "+id+" was deleted";
    }
}
