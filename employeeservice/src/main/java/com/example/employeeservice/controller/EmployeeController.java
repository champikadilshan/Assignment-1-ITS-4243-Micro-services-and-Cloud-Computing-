package com.example.employeeservice.controller;

import com.example.employeeservice.entity.Employee;
import com.example.employeeservice.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping
    public ResponseEntity<?> createEmployee(@RequestBody Employee employee) {
        try {
            logger.info("Received request to create employee: {}", employee);

            if (employee.getFirstName() == null || employee.getLastName() == null) {
                logger.error("First name or last name is null");
                return ResponseEntity.badRequest().body("First name and last name are required");
            }

            Employee savedEmployee = employeeRepository.save(employee);
            logger.info("Successfully created employee: {}", savedEmployee);
            return ResponseEntity.ok(savedEmployee);

        } catch (Exception e) {
            logger.error("Error creating employee", e);
            return ResponseEntity.badRequest().body("Error creating employee: " + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getEmployee(@PathVariable Long id) {
        logger.info("Fetching employee with id: {}", id);

        try {
            return employeeRepository.findById(id)
                    .map(employee -> {
                        logger.info("Found employee: {}", employee);
                        return ResponseEntity.ok(employee);
                    })
                    .orElseGet(() -> {
                        logger.info("Employee not found with id: {}", id);
                        return ResponseEntity.notFound().build();
                    });
        } catch (Exception e) {
            logger.error("Error fetching employee", e);
            return ResponseEntity.badRequest().body("Error fetching employee: " + e.getMessage());
        }
    }
}