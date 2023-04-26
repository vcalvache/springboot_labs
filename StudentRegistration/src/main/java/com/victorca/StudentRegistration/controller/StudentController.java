package com.victorca.StudentRegistration.controller;

import org.springframework.ui.Model;
import com.victorca.StudentRegistration.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @RequestMapping("/")
    public String studentsIndex(){
        // This is the student index site for crud operations
        return "student";
    }

    @RequestMapping("/allStudents/")
    public String getAllStudents(Model model){
        model.addAttribute("students", studentService.getAllStudents());
        //here will list all the students on the DB
        return "allStudents";
    }

    @RequestMapping("/new/")
    public String createStudent(){
        return "createStudentForm";
    }

    @RequestMapping("/update/")
    public String updateStudent(){
        // here will be needed all users list.
        return "updateStudents";
    }

    @RequestMapping("/delete/")
    public String deleteStudent(){
        // a list with all the students and to option to delete will be added here
        return "deleteStudent";
    }




}
