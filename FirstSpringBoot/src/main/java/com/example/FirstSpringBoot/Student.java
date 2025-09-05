package com.example.FirstSpringBoot;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Student {
    @Autowired
    private Writer writer;


//    @Autowired //field injection
//    Pen pen;
    int age;

    /*@Autowired //setter injection
    public void setPen(Pen pen) {
        this.pen = pen;
    }*/

  /*  //when only one constructer is present for this class eg.for student call only below constructor
    //exist then no need to auto wire -- this is constructor injection
    @Autowired
    public Student(Pen pen) {
        this.pen = pen;
    }

    //if multiple constructor is present then we need to autowire
    public Student(){
        System.out.println("student is created");
    }
*/
    public void writeExam(){
        writer.write();
    }
    public void show(){
        System.out.println("show method of student");
    }
}
