package com.spmvcdemo.SpringMVCdemo.repository;

import com.spmvcdemo.SpringMVCdemo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
