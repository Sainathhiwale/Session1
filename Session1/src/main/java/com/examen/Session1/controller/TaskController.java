package com.examen.Session1.controller;

import com.examen.Session1.entity.Task;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/task")
public class TaskController {
     static List<Task> taskList = new ArrayList<>();

    @PostMapping("/")
    public String save(@RequestBody Task task){
     taskList.add(task);
     return "save Successfully";
    }

    @GetMapping("/")
    public List<Task> getAll(){
        return taskList;
    }
}
