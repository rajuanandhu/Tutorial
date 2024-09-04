package com.example.springdb.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name="employ")
public class Employ {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long empId;
    private String name;
    private Double salary;
    private String email;

    // Getters and Setters

    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}