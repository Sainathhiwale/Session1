package com.examen.Session1.controller;

import com.examen.Session1.domain.Employee;
import com.examen.Session1.services.EmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api/v2/employee") //Presentation Layer (Controller)
public class EmployeeController {

    @Autowired
    EmployeeServices employeeServices;

    @PostMapping("/save")
    public ResponseEntity<Employee> save(@RequestBody Employee employee){
        return new ResponseEntity<>(employeeServices.save(employee), HttpStatus.CREATED);
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<Employee>> getAll(){
        return new ResponseEntity<>(employeeServices.getAll(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getById(@PathVariable Long id){
        return new ResponseEntity<>(employeeServices.getById(id),HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<Employee> update(@RequestBody Employee employee){
        return new ResponseEntity<>(employeeServices.update(employee),HttpStatus.OK);
    }
}
