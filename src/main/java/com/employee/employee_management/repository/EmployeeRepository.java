package com.employee.employee_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.employee_management.model.Employee;

/**
 * Repository interface for Employee entity.
 * Spring Data JPA automatically implements basic CRUD methods.
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}

