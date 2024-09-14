package com.examen.Session1.repository;

import com.examen.Session1.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyTaskRepository extends JpaRepository<Task,Long> {
}
