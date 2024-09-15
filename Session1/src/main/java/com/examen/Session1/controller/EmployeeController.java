package com.examen.Session1.controller;

import com.examen.Session1.domain.Employee;
import com.examen.Session1.services.EmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/v2/employee") //Presentation Layer (Controller)
public class EmployeeController {

    @Autowired
    EmployeeServices employeeServices;

    @PostMapping("/save")
    public ResponseEntity<Employee> save(@RequestBody Employee employee){
        return new ResponseEntity<>(employeeServices.save(employee), HttpStatus.CREATED);
    }
}
