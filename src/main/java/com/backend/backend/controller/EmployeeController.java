package com.backend.backend.controller;


import com.backend.backend.entity.Employee;
import com.backend.backend.service.EmployeeService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private EmployeeService employeeService ;

    public EmployeeController( EmployeeService employeeService ){
        super();
        this.employeeService = employeeService ;
    }

    //build create employee REST API
    @PostMapping
    public ResponseEntity<Employee>saveEmployee(@RequestBody Employee employee ){
        return new ResponseEntity<Employee>( employeeService.saveEmployee( employee ) , HttpStatus.CREATED ) ;
    }
    // build get all employee REST API
    @GetMapping
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees() ;
    }
    // build get employee by id REST API
    //http://localhost:8080/api/employees/1
    @GetMapping("{id}")

    public ResponseEntity<Employee> getemployeeById(@PathVariable("id") long employeeId ){
        return new ResponseEntity<Employee>( employeeService.getEmployeeById( employeeId ) , null , HttpStatus.OK   ) ;
    }
    //http://localhost:8080/api/employees/1/
    @PutMapping("{id}")
    public ResponseEntity<Employee> udpateEmployee( @PathVariable("id") long id , @RequestBody Employee employee ){
        return new ResponseEntity<Employee>( employeeService.updateEmployee( employee , id ) , HttpStatus.OK ) ;
    }
    // http://localhost:8080/api/employees/1
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id ){
        //delete employee form DB
        employeeService.deleteEmployee( id );

        return new ResponseEntity<String>( "Employee deleted successfully "  , HttpStatus.OK ) ;


    }


}
