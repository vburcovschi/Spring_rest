package com.vburcovschi.spring.rest.dao;


import com.vburcovschi.spring.rest.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    public List<Employee> getAllEmployee();

    public void saveEmployee(Employee employee);

    Employee getEmployee(int id);

    public void removeEmployee(int id);
}
