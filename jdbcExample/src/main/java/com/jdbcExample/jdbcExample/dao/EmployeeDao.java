package com.jdbcExample.jdbcExample.dao;

import com.jdbcExample.jdbcExample.model.Employee;
import com.jdbcExample.jdbcExample.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.Types;
import java.util.List;
import java.util.Map;

@Component
@Repository
public class EmployeeDao implements EmployeeRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public String saveEmployee(Employee employee) {
             String sql="Insert into employee values(?,?,?)";
             jdbcTemplate.update(sql,new Object[]{employee.getId(),employee.getName(),employee.getCity()});
             return "Student added successfully";
    }

    @Override
    public List<Employee> getAllEmployees() {
        String sql="select * from employee";
        List<Employee> list=jdbcTemplate.query(sql, new BeanPropertyRowMapper(Employee.class));
        return list;
    }

    @Override
    public Employee getEmployeeById(Integer id) {
        String sql="select * from employee";
        Employee employee=(Employee) jdbcTemplate.queryForObject(sql, new Object[]{id},
                new int[]{Types.INTEGER},
                new BeanPropertyRowMapper(Employee.class));
                return employee ;
    }

    @Override
    public String deleteEmployee(Integer id) {
        String sql="delete from employee id=?";
        jdbcTemplate.update(sql, new Object[]{id});
        return "updated successfully";
    }

    @Override
    public List<Map<String, Object>> getCombinedData() {
        String sql="select a.id,a.name,a.city,b.name from employee, department b where a.dept_id=b.id";
        List<Map<String,Object>> list=jdbcTemplate.queryForList(sql);
        return list;
    }


}
