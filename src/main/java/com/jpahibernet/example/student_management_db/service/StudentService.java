package com.jpahibernet.example.student_management_db.service;

import com.jpahibernet.example.student_management_db.model.Student;
import com.jpahibernet.example.student_management_db.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service  // it contains business logics of the application.
public class StudentService {

    @Autowired  // it is used to create object in spring boot
    private StudentRepository studentRepository;
    public String addStudent(Student stu){
        studentRepository.save(stu);
        return "Student saved into db Successfully";
    }


    public Student getStudentById(int id){
        Optional<Student> stuopt= studentRepository.findById(id);
        if(stuopt.isPresent()){
            return stuopt.get();
        }
        return null;
    }

    public List<Student> getAllStudents(){
        List<Student> stuLi = studentRepository.findAll();
        return stuLi;
    }

    public String countStudents(){
        long totalCount = studentRepository.count();
        return "Total no.of students present"+totalCount;
    }

    public String deleteStudentById(int id){
        studentRepository.deleteById(id);
        return "Student deleted Successfully";
    }

    public String updateStudentByPut(int id,Student newStudentRequest){
        //find student with id
        //if the student is present update it
        //else no need to update

        Student alreadyExistinggStudent = getStudentById(id);
        if(alreadyExistinggStudent!=null){
            //perform update operation
            studentRepository.save(newStudentRequest);
            return "Student updated Successfully";

        }else{
            return "Update cannot be performed as Student with id:"+id+"is not present";
        }
    }

    public String updateStudentByPatch(int id,String name){
        //find student with id
        //if the student is present update it
        //else no need to update

        Student alreadyExistinggStudent = getStudentById(id);
        if(alreadyExistinggStudent!=null){
            //perform update operation
            alreadyExistinggStudent.setName(name);
            studentRepository.save(alreadyExistinggStudent);
            return "Student updated Successfully";

        }else{
            return "Update cannot be performed as Student with id:"+id+"is not present";
        }
    }
}
