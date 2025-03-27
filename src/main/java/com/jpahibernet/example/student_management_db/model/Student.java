package com.jpahibernet.example.student_management_db.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity  // it is an entity or model class which directly represents the database tables/schema.
@Table(name="student") //@Table  it creates table inside database
public class Student {

    @Id  // it is the primary key of the table and cannot be duplicated
    @Column(name="id")  //@Column - means it takes as variable name
    private  int id;

    @Column(name="name", nullable = false)  // it creates a column inside mysql database table.
    private String name;

    @Column(name="age")
    private int age;

    @Column(name="email", nullable = false) //nullable=false - it cannot be null
    private String email;

    @Column(name="grade", nullable = false)
    private String grade;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
