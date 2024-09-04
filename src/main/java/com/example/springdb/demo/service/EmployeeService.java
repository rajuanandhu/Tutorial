package com.example.springdb.demo.service;

import com.example.springdb.demo.entity.Employ;
import com.example.springdb.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employ> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Optional<Employ> getEmployeeById(Long empId) {
        return employeeRepository.findById(empId);
    }
    public List<Employ> saveEmployees(List<Employ> employees) {
        return employeeRepository.saveAll(employees);
    }


    public Employ saveEmployee(Employ employee) {
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Long empId) {
        employeeRepository.deleteById(empId);
    }

    public Employ saveEmploy(Employ employee) {
        employeeRepository.save(employee);
        return employee;
    }
}
