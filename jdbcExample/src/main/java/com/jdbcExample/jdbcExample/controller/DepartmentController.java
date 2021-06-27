package com.jdbcExample.jdbcExample.controller;

import com.jdbcExample.jdbcExample.model.Department;
import com.jdbcExample.jdbcExample.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class DepartmentController {

    @Autowired
    private DepartmentRepository departmentRepository;

    @PostMapping("/saveDepartment")
    public String addDepartment(@RequestBody Department department){
        return departmentRepository.insertDepartment(department);
    }
}
