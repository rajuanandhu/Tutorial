package com.example.springdb.demo.Controller;



import com.example.springdb.demo.entity.Employ;
import com.example.springdb.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
 

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Employ> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")

    public ResponseEntity<Employ> getEmployeeById(@PathVariable("id") Long empId) {
        Optional<Employ> employee = employeeService.getEmployeeById(empId);
        return employee.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @RequestMapping("/createemployee")
    public ResponseEntity<Employ> createEmployee(@RequestBody Employ employee) {
        Employ savedEmployee = employeeService.saveEmploy(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEmployee);

    }
    @PostMapping
    @RequestMapping("/batch")
    public ResponseEntity<List<Employ>> createEmployees(@RequestBody List<Employ> employees) {
        List<Employ> savedEmployees = employeeService.saveEmployees(employees);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEmployees);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employ> updateEmployee(@PathVariable("id") Long empId, @RequestBody Employ employee) {
        if (!employeeService.getEmployeeById(empId).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        employee.setEmpId(empId);
        Employ updatedEmploy = employeeService.saveEmploy(employee);
        return ResponseEntity.ok(updatedEmploy);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmploy(@PathVariable("id") Long empId) {
        if (!employeeService.getEmployeeById(empId).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        employeeService.deleteEmployee(empId);
        return ResponseEntity.noContent().build();
    }
}
