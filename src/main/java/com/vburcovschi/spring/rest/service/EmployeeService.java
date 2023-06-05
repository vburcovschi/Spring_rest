package com.vburcovschi.spring.rest.service;


import com.vburcovschi.spring.rest.entity.Employee;

import java.util.List;


public interface EmployeeService {
    public List<Employee> getAllEmployee();

    public void saveEmployee(Employee employee);

    public Employee getEmployee(int id);

    public void removeEmployee(int id);
}
