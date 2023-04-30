package com.victorca.StudentManager.controller;

import com.victorca.StudentManager.model.Student;
import com.victorca.StudentManager.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @RequestMapping("/students")
    public String getAllUsers(Model model){
        // fetch all users, add to model
        model.addAttribute("students", studentService.getAllStudents());
        return "student/students";
    }
    @RequestMapping("/createStudent")
    public String createUser(Student student){
        studentService.createStudent(student);
        return "redirect:students";
    }

    @RequestMapping("/studentForm")
    public String sendForm(){

        return "student/studentForm";
    }

    @RequestMapping("/packedStudent")
    public String packedStudents(@RequestParam("studentID") String studentID, Model model){

        Student studentFound = studentService.findStudentByID(studentID);

        if (studentFound != null){
            model.addAttribute("studentFromController", studentFound);
            model.addAttribute("message", "Student  found");}
        else
            model.addAttribute("message", "Student not found");

        return "student/studentToUpdate";
    }

    @PostMapping("/updateStudent/{studentID}")
    public String updateUser(@PathVariable("studentID") String studentID,
                             Student updatedStudent) {

        Student studentFound = studentService.findStudentByID(studentID);

        if (studentFound != null) {
            studentService.updateStudentByStudentID(updatedStudent);
            return "redirect:/student/students";
        } else return "student/studentNotFound";


    }

    @RequestMapping("/deleteStudent")
    public String deleteStudent(@RequestParam("studentID") String studentID) {

        Student studentFound = studentService.findStudentByID(studentID);

        if (studentFound != null) {
            studentService.deleteStudentByStudentID(studentID);
            return "redirect:/student/students";
        } else return "student/studentNotFound";


    }

    @RequestMapping("/studentDetails")
    public String studentDetails(@RequestParam("studentID") String studentID, Model model) {

        Student studentFound = studentService.findStudentByID(studentID);

        if (studentFound != null) {
            model.addAttribute("student",studentFound );
            return "/student/studentDetails";
        } else return "student/studentNotFound";

    }

    @RequestMapping("/createFakeStudents")
    public String createFakeStudents (@RequestParam("qty") int qty) {
        StudentService.populateDB(qty);
        return "redirect:/student/students";
    }
}
