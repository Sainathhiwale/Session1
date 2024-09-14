package com.examen.Session1.services;

import com.examen.Session1.domain.MyTask;
import com.examen.Session1.exception.MyException;
import com.examen.Session1.repository.MyTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyTaskServices {

    @Autowired
    MyTaskRepository myTaskRepository;

    public MyTask save(MyTask myTask){
      return  myTaskRepository.save(myTask);
    }
    // get list of object stored in tables
    public List<MyTask> getAll(){
        return  myTaskRepository.findAll();
    }

    public MyTask getById(Long id) {
        return myTaskRepository.findById(id).orElseThrow(()-> new MyException("NO record found with the id: "+id ));

    }

    public MyTask update(MyTask myTask) {
      MyTask dbRec=myTaskRepository.findById(myTask.getId()).get();
       dbRec.setDescription(myTask.getDescription());
        return myTaskRepository.save(myTask);
    }

    public String delete(Long id) {
        myTaskRepository.deleteById(id);
        return "record deleted successfully";
    }

    public List<MyTask> filter(String author) {
        return myTaskRepository.findByAuthor(author);
    }
}
