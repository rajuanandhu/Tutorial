package com.example.springdb.demo.repository;

import com.example.springdb.demo.entity.Employ;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface EmployeeRepository extends JpaRepository<Employ, Long> {
}
