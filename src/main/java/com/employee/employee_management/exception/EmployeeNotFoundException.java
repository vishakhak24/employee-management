package com.employee.employee_management.exception;

/**
 * Custom exception thrown when an employee is not found.
 */
public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(String message) {
        super(message);
    }
}

