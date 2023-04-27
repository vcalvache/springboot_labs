package com.victorca.StudentRegistration.controller;

import com.victorca.StudentRegistration.model.Student;
import org.springframework.ui.Model;
import com.victorca.StudentRegistration.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @RequestMapping("/")
    public String studentsIndex(){
        // This is the student index site for crud operations
        // contains a list of links with all the available operations
        return "student";
    }

    @RequestMapping("/allStudents/")
    public String getAllStudents(Model model){
        model.addAttribute("students", studentService.getAllStudents());
        //here will list all the students on the DB
        return "allStudents";
    }

    @GetMapping("/createStudent/")
    public String createStudent(Model model) {
        model.addAttribute("student", new Student());
        return "createStudentForm";
    }
    /*
    @PostMapping("/createStudent/{studentID}")
    public String createStudent(@PathVariable("studentID") String studentID, Optional<Student> student){
        if(studentService.getStudent(studentID) != null){
            return "Already on DB";
        }
        if(student.isPresent()) {
            studentService.saveStudent(student.get());
        }
        return "redirect:/student/createStudent/";
    }

    @RequestMapping("/createStudent/")
    public String createStudent(Student student){
        studentService.saveStudent(student);
        return "createStudentForm";
    }
    @PostMapping(value = "/createStudent/{studentID}")
    public String createStudent(@PathVariable("studentID") String studentID, Optional<Student> student) {
        if (studentService.getStudent(studentID) != null) {
            return "Already on DB";
        }
        if (student.isPresent()) {
            studentService.saveStudent(student.get());
        }
        return "redirect:/student/createStudent/";
    }

     */

    @RequestMapping("/update/")
    public String updateStudent(){
        // here will be needed all users list.
        return "updateStudents";
    }
    // TODO: postmapping with update student

    @RequestMapping("/delete/")
    public String deleteStudent(){
        // a list with all the students and to option to delete will be added here
        return "deleteStudent";
    }
}