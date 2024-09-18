package com.examen.Session1.services;

import com.examen.Session1.domain.Employee;
import com.examen.Session1.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



@Service
public class EmployeeServices {  //Business Logic Layer (Service)

    List<Employee> employeeList=new ArrayList<>(Arrays.asList(
            Employee.builder().name("user1").department("IT").address("Pune").build(),
            Employee.builder().name("user2").department("IT").address("Pune").build(),
            Employee.builder().name("user3").department("IT").address("Pune").build(),
            Employee.builder().name("user4").department("IT").address("Pune").build()

    ));
    public List<Employee> getAll() {
        return employeeList;
    }
   /* @Autowired
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

    public String delete(Long id) {
        employeeRepository.deleteById(id);
        return "Records delete successfully";
    }*/
}
