package com.jdbcExample.jdbcExample.dao;

import com.jdbcExample.jdbcExample.model.Department;
import com.jdbcExample.jdbcExample.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class DepartmentDao implements DepartmentRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public String insertDepartment(Department department) {
        String sql="Insert into employee values(?,?,?)";
        jdbcTemplate.update(sql,new Object[]{department.getId(),department.getName()});
        return "Student added successfully";

    }
}
