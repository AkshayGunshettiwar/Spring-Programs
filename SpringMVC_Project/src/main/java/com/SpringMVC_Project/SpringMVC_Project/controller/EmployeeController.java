package com.SpringMVC_Project.SpringMVC_Project.controller;

import com.SpringMVC_Project.SpringMVC_Project.model.Employee;
import com.SpringMVC_Project.SpringMVC_Project.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/")
    public String ViewHome(Model model){
        List<Employee> employeeList=employeeRepository.findAll();
        model.addAttribute("employee", employeeList);
        return "index";

    }

    @RequestMapping("/new")
    public String showNewEmpForm(Model model){
        Employee employee=new Employee();
        model.addAttribute("employee", employee);
        return "insert";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveEmp(@ModelAttribute("employee") Employee employee){
        employeeRepository.save(employee);
        return "redirect:/";

    }

    @RequestMapping("/update/{id}")
    public ModelAndView showUpdateEmpForm(@PathVariable Integer id){
        ModelAndView mav=new ModelAndView("update");
        Employee employee=employeeRepository.findById(id).get();
        mav.addObject("employee", employee);
        return mav;
    }

    @RequestMapping("/delete/{id}")
    public String delEmp(@PathVariable Integer id){
        employeeRepository.deleteById(id);
        return "redirect:/";
    }
}
