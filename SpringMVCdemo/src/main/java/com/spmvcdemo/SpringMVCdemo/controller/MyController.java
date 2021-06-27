package com.spmvcdemo.SpringMVCdemo.controller;

import com.spmvcdemo.SpringMVCdemo.model.Student;
import com.spmvcdemo.SpringMVCdemo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MyController {

    @Autowired
    private StudentRepository studentRepository;

//    @GetMapping("/index")
//    public String check(){
//        return "index";
//    }
//
//    @ResponseBody
//    @GetMapping("/check")
//    public String getdata(){
//        return "checking controller";
//    }

    @GetMapping("/home")
    public String Stuhome(Model model){
        model.addAttribute("student", new Student());
        return "index";

    }

    @PostMapping(value = "/saveStu")
    public String saveStu(@ModelAttribute Student student){
        System.out.println(student);
        studentRepository.save(student);
        return "success";
    }




}
