package com.example.FirstApi.Service;

import com.example.FirstApi.Model.Student;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentService {
    /*List<Student> list=new ArrayList<>();
    {
        *//*
        * In Java, you cannot have method calls floating directly in the class body like that.
            That’s only allowed inside:
            * constructor
            * method
            * initializer block {}
           *//*
    list.add(new Student(12,23,"jat"));
    }*/

    List<Student> students=new ArrayList<>(
            Arrays.asList(
                    new Student(13,100,"kris"),
                    new Student(21,101,"zirk")
            )
    );

    public List<Student> getStudent() {
        return students;
    }

    public String home() {
        return "welcome to student home";
    }

    //this solved a big problem - alway return the student or null using optional let the
     //controller decide what to do when student is unavailable
    public Student getstdByrno(int rno) {
        return students.stream()
                .filter(pasango -> pasango.getRoll() == rno)
                .findFirst()
                .orElse(null);
        //in orElse we can create
        //      new student with 0,0,"unknown"
        //      .orElseThrow() -> new RuntimeException(" Student Not found ")
    }

    public Optional<Student> getstdByrnoAdvance(int rno) {
        return students.stream()
                .filter(pasango -> pasango.getRoll() == rno)
                .findFirst();
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }

    public Student updateStudent(Student student) {
        students=students.stream()
                .map(s -> s.getRoll() == student.getRoll() ? student : s)
                .collect(Collectors.toList());
        return student;
    }

    public String deleteStudent(int rno) {
        /*students=students.stream()
                .filter(pasango-> pasango.getRoll()!=rno)
                .collect(Collectors.toList());
        return "deleted sucessfully";*/

        boolean removed=students.removeIf(pasango-> pasango.getRoll()==rno);
        if (removed) return "deleted successfully";
        return "No such student found";
    }
}
