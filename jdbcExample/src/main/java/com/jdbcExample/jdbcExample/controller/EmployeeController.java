package com.jdbcExample.jdbcExample.controller;

import com.jdbcExample.jdbcExample.dao.EmployeeDao;
import com.jdbcExample.jdbcExample.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @PostMapping("/save")
    public String saveEmployee(@RequestBody Employee employee){
        return employeeDao.saveEmployee(employee);
    }

    @GetMapping("/getallemployees")
    public List<Employee> getEmployeeList(){
        return employeeDao.getAllEmployees();
    }

    @GetMapping("getemployees/{id}")
    public Employee getEmployee(@PathVariable Integer id){
        return employeeDao.getEmployeeById(id);
    }

    @GetMapping("deleteemployee/{id}")
    public String deleteEmployee(@PathVariable Integer id){
        return employeeDao.deleteEmployee(id);
    }

    @GetMapping("/joindata")
    public List<Map<String, Object>> getJoinData() {
        return employeeDao.getCombinedData();
    }
}

