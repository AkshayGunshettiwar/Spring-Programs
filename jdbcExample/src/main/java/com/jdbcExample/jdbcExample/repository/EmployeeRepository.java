package com.jdbcExample.jdbcExample.repository;

import com.jdbcExample.jdbcExample.model.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeRepository {
    String saveEmployee(Employee employee);

    List<Employee> getAllEmployees();

    Employee getEmployeeById(Integer id);

    String deleteEmployee(Integer id);

    List<Map<String,Object>> getCombinedData();

}
