package com.examen.Session1.services;

import com.examen.Session1.domain.Employee;
import com.examen.Session1.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmployeeServices {  //Business Logic Layer (Service)
    @Autowired
    EmployeeRepository employeeRepository;

    public Employee save(Employee employee){
      return  employeeRepository.save(employee);
    }

    public Employee getById(Long id) {
        return employeeRepository.getReferenceById(id);
    }

    public List<Employee> getAll() {
         return employeeRepository.findAll();
    }

    public Employee update(Employee employee) {
        return employeeRepository.save(employee);
    }
}
