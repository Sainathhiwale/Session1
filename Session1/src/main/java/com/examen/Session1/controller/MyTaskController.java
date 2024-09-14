package com.examen.Session1.controller;

import com.examen.Session1.domain.MyTask;
import com.examen.Session1.services.MyTaskServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/task")
public class MyTaskController {

    @Autowired
    MyTaskServices myTaskServices;

    @PostMapping("/save")
    public ResponseEntity<MyTask> save(@RequestBody MyTask myTask){
        return new ResponseEntity<>(myTaskServices.save(myTask), HttpStatus.CREATED);
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<MyTask>> getAll(){
        return new ResponseEntity<>(myTaskServices.getAll(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MyTask> getById(@PathVariable long id){
        return new ResponseEntity<>(myTaskServices.getById(id),HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<MyTask> update(@RequestBody MyTask myTask){
        return new ResponseEntity<>(myTaskServices.update(myTask),
                HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        return new ResponseEntity<>(myTaskServices.delete(id),
                HttpStatus.OK);
    }
    @GetMapping("/filter")
    public ResponseEntity<List<MyTask>> filter(@RequestParam String author){
        return new ResponseEntity<>(
                myTaskServices.filter(author),
                HttpStatus.OK
        );
    }

}
