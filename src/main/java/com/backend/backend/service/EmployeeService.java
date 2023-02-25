package com.backend.backend.service;

import com.backend.backend.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    Employee saveEmployee( Employee employee ) ;

    List<Employee> getAllEmployees() ;

    Employee getEmployeeById(long id ) ;

}
