package com.backend.backend.service.impl;

import com.backend.backend.entity.Employee;
import com.backend.backend.exception.ResourceNotFoundException;
import com.backend.backend.reposiotry.EmployeeRepository;
import com.backend.backend.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository ;

    public EmployeeServiceImpl( EmployeeRepository employeeRepository ){
        super();
        this.employeeRepository = employeeRepository ;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
            return employeeRepository.save( employee ) ;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll() ;

    }

    @Override
    public Employee getEmployeeById(long id) {
        /*
        Optional<Employee> employee = employeeRepository.findById( id ) ;
        if( employee.isPresent() ){ return employee.get() ; }
        else throw new ResourceNotFoundException("Employee" , "Id" , id ) ;

         */
        // Method second solving it using lambda expression
        return employeeRepository.findById( id ).orElseThrow( () -> new ResourceNotFoundException("Employee" , "Id" , id ) ) ;

    }

    @Override
    public Employee updateEmployee(Employee employee, long id) {

        // check whether employee with givne id exists or not

        Employee existingemployee = employeeRepository.findById( id).orElseThrow( () -> new ResourceNotFoundException("Employee" , "Id" , id ) ) ;

        existingemployee.setFirstName(employee.getFirstName());
        existingemployee.setLastName(employee.getLastName());
        existingemployee.setEmail(employee.getEmail());
        // save existing employee to DB

        employeeRepository.save( existingemployee ) ;

        return existingemployee ;
    }




}
