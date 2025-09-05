package com.example.JPAproject.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity //states that this class is a relational data
public class Student {
    @Id//means roll number is a primary key
    private int roll;
    private String name;
    private String gender;
    private String technology;

    public Student() {
    }

    public Student(String gender, String name, int roll, String technology) {
        this.gender = gender;
        this.name = name;
        this.roll = roll;
        this.technology = technology;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRoll() {
        return roll;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }

    public String getTechnology() {
        return technology;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }
}
