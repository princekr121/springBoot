package com.backend.backend.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.web.bind.annotation.RestController;

@Data
@Entity
@Table(name = "employees")
public class Employee{
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    private long id ;
    @Column(name = "first_name" , nullable = false )
    private String firstName ;
    @Column( name = "last_name")
    private String lastName ;
    @Column( name = "email")
    private String email ;





}
