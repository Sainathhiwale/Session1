package com.examen.Session1.repository;

import com.examen.Session1.domain.MyTask;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MyTaskRepository extends JpaRepository<MyTask,Long> {
    List<MyTask> findByAuthor(String author);

}
