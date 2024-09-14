package com.examen.Session1.controller;

import com.examen.Session1.entity.Task;
import com.examen.Session1.repository.MyTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/task")
public class TaskController {

    @Autowired
    MyTaskRepository myTaskRepository;

    @PostMapping("/save")
    public String save(@RequestBody Task task){
        myTaskRepository.save(task);
        return "save successfully";
    }
}
