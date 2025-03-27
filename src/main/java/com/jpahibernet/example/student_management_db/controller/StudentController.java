package com.jpahibernet.example.student_management_db.controller;

import com.jpahibernet.example.student_management_db.model.Student;
import com.jpahibernet.example.student_management_db.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("student/apis")
public class StudentController {

    // controller <->  service <-> repository

    @Autowired
    private StudentService studentService;

    @PostMapping("/save")
    public String addStudent(@RequestBody Student stu){
        String res= studentService.addStudent(stu);
        return res;

    }

    @GetMapping("/find/{id}")
    public Student getStudentById(@PathVariable int id){
        Student stu = studentService.getStudentById(id);
        return stu;
    }

    @GetMapping("/findAll")
    public List<Student> getAllStudents(){
        List<Student> stuList = studentService.getAllStudents();
        return stuList;
    }

    @GetMapping("/count")
    public String getCountOfStudents(){
        String res=studentService.countStudents();
        return res;
    }

    @DeleteMapping("/delete/{id}")
    public String deleteStudentById(@PathVariable int id) {
        String res = studentService.deleteStudentById(id);
        return res;
    }

    @PutMapping("/updatePut/{id}")  // updates the whole obj or specific no.of fields
    public String updateStudent(@PathVariable int id,@RequestBody Student newStudentRequest){
        String res=studentService.updateStudentByPut(id,newStudentRequest);
        return res;
    }

    //@RequestParam - it takes the input in the form of request parameter query.
    @PatchMapping("/updatePatch/{id}")   //or @PatchMapping("/updatePatch/{id}/{name}")  updates only one specific fields
    public String updateStudentName(@PathVariable int id, @RequestParam String name){
        String res=studentService.updateStudentByPatch(id,name);
        return res;
    }

}
