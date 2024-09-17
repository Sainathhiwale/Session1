package com.examen.Session1.controller;

import com.examen.Session1.domain.Employee;
import com.examen.Session1.services.EmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@RestController
@RequestMapping("/api/v2/employee") //Presentation Layer (Controller)
public class EmployeeController {

    @Autowired
    EmployeeServices employeeServices;

    List<Employee> employeeList = new ArrayList<>(Arrays.asList(
            new Employee(0,"sainath","IT","Pune")
    ));

    @GetMapping("")
    public ResponseEntity<List<Employee>> getall(){
        return new ResponseEntity<>(employeeList,HttpStatus.OK);
    }
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
    @DeleteMapping("/{id}")
    public ResponseEntity<String>delete(@PathVariable Long id){
        return new ResponseEntity<>(employeeServices.delete(id),HttpStatus.OK);
    }
}
