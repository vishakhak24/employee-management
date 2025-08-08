package com.employee.employee_management.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.employee_management.model.Employee;
import com.employee.employee_management.service.EmployeeService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

/**
 * REST Controller for managing Employees.
 * Provides endpoints for CRUD operations.
 */
@RestController
@RequestMapping("/api/employees")
@SecurityRequirement(name = "bearerAuth")  // Requires JWT token in Swagger
public class EmployeeController {

	@Autowired
    private EmployeeService employeeService;

    /**
     * GET /api/employees
     * Fetch all employees.
     */

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    /**
     * GET /api/employees/{id}
     * Fetch an employee by ID.
     */

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }

    /**
     * POST /api/employees
     * Create a new employee.
     */

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        return ResponseEntity.ok(employeeService.createEmployee(employee));
    }

    /**
     * PUT /api/employees/{id}
     * Update an existing employee.
     */

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        return ResponseEntity.ok(employeeService.updateEmployee(id, employee));
    }

    /**
     * DELETE /api/employees/{id}
     * Remove an employee from the system.
     */

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.ok("Employee with ID " + id + " deleted successfully.");
    }
}

