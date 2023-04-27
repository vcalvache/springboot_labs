package com.victorca.StudentAdministration.controller;

import com.github.javafaker.Faker;
import com.github.javafaker.IdNumber;
import com.victorca.StudentAdministration.utils.ObjectsCreation;
import org.springframework.ui.Model;
import com.victorca.StudentAdministration.model.Student;
import com.victorca.StudentAdministration.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.*;

@Controller
@RequestMapping("")
public class StudentController {


    @Autowired
    StudentService studentService;


    @RequestMapping("")
    public String index(Model model){
        return "index";
    }

    @RequestMapping(value={"/getAllStudents", "/getAllStudents/"})
    public String getAllStudents(Model model){
        model.addAttribute("students", studentService.getAllStudents());
        return "getallstudents";
    }


    @GetMapping(value= {"/createStudent", "/createStudent/"})
    public String createStudent(Model model){
        model.addAttribute("student", new Student());
        return "createStudent";
    }

    @PostMapping(value= "/createStudent")
    public String createStudent(@ModelAttribute("student") Student student){
        if (studentService.getIndex(student.getIdNumber()) != -1){
            studentService.saveStudent(student);
        }
        return "redirect:/createStudent";
    }


    @RequestMapping(value="/getStudent/{idNUmber}")
    public String getStudent(@PathVariable("idNumber")String idNumber, Model containerToView){
        Student studentFromDB = studentService.getStudent(idNumber);
        containerToView.addAttribute("student", studentFromDB);
        return "getstudent";
    }


    @RequestMapping(value={"/updateStudent", "/updateStudent/"})
    public String updateStudents(Model model){
        model.addAttribute("students", studentService.getAllStudents());
        return "updatestudent";
    }

    @RequestMapping(value={"/deleteStudent", "/deleteStudent/"})
    public String deleteStudent(Model model){
        model.addAttribute("students", studentService.getAllStudents());
        return "deletestudent";
    }

    @GetMapping("/deleteStudent/{idNumber}")
    public String deleteStudent(@PathVariable("idNumber") String idNumber){
        studentService.deleteStudent(idNumber);
        return "redirect:/getAllStudents";
    }
}
