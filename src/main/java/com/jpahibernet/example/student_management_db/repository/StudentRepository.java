package com.jpahibernet.example.student_management_db.repository;

import com.jpahibernet.example.student_management_db.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository  // It performs the database operations and it is the data layer.
//                                              model class name,primary key datatype.
public interface StudentRepository extends JpaRepository<Student,Integer> {
}
