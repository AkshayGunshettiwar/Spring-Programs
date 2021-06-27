package com.SpringMVC_Project.SpringMVC_Project.repository;

import com.SpringMVC_Project.SpringMVC_Project.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
