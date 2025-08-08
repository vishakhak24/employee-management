package com.employee.employee_management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.employee_management.exception.EmployeeNotFoundException;
import com.employee.employee_management.model.Employee;
import com.employee.employee_management.repository.EmployeeRepository;

/**
 * Service layer handling business logic for Employee operations.
 */
@Service
public class EmployeeService {

	@Autowired
    private EmployeeRepository employeeRepository;

    /**
     * Fetch all employees.
     */
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    /**
     * Fetch employee by ID.
     */
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee with ID " + id + " not found"));
    }

    /**
     * Add a new employee.
     */
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    /**
     * Update an existing employee.
     */
    public Employee updateEmployee(Long id, Employee updatedEmployee) {
        Employee existing = getEmployeeById(id);
        existing.setName(updatedEmployee.getName());
        existing.setDepartment(updatedEmployee.getDepartment());
        existing.setSalary(updatedEmployee.getSalary());
        return employeeRepository.save(existing);
    }

    /**
     * Delete employee by ID.
     */
    public void deleteEmployee(Long id) {
        Employee existing = getEmployeeById(id);
        employeeRepository.delete(existing);
    }
}

