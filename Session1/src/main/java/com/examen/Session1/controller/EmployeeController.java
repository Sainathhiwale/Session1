package com.examen.Session1.controller;

import com.examen.Session1.domain.Employee;
import com.examen.Session1.services.EmployeeServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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
    @Operation(
            description = "Save Employee",
            responses = {
                    @ApiResponse(responseCode = "201",
                            description = "save the employee details",
                            content = {
                            @Content(
                                    mediaType = "application/json",
                                    examples = {
                                            @ExampleObject (
                                                    value = "{{\n" +
                                                            "  \"id\": 0,\n" +
                                                            "  \"name\": \"string\",\n" +
                                                            "  \"department\": \"string\",\n" +
                                                            "  \"address\": \"string\"\n" +
                                                            "}\n}"
                                            )
                                    }
                            )
                            }
                    )
            }
    )
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
    public ResponseEntity<Employee> update(@io.swagger.v3.oas.annotations.parameters.RequestBody(
                             content ={
                                     @Content(
                                             mediaType = "application/json",
                                             examples = {
                                                     @ExampleObject (
                                                             value = "{{\n" +
                                                                     "  \"id\": 0,\n" +
                                                                     "  \"name\": \"string\",\n" +
                                                                     "  \"department\": \"string\",\n" +
                                                                     "  \"address\": \"string\"\n" +
                                                                     "}\n}"
                                                     )
                                             }
                                     )
                             })
    @RequestBody Employee employee){
        return new ResponseEntity<>(employeeServices.update(employee),HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String>delete(@PathVariable Long id){
        return new ResponseEntity<>(employeeServices.delete(id),HttpStatus.OK);
    }
}
