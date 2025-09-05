package com.example.FirstApi.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private int roll;
    private  int mark;
    private String name;

    /* instead we can use allargsconstructor lombok
    public Student(String name,int roll ,int mark) {
        this.mark = mark;
        this.name = name;
        this.roll = roll;
    }*/
}
