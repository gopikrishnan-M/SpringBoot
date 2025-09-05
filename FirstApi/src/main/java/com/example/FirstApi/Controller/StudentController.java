package com.example.FirstApi.Controller;

import com.example.FirstApi.Model.Student;
import com.example.FirstApi.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping("/")
    public String home(){
        return studentService.home();
    }

    @GetMapping("/students")
    public List<Student> getStudent(){
        return studentService.getStudent();
    }

    @GetMapping("/student/{rno}")
    public  Student getStdByroll(@PathVariable("rno") int rollnum){
        return studentService.getstdByrno(rollnum);
    }

    @GetMapping("/student4/{rno}")
    public ResponseEntity<Student> getStudentByRno(@PathVariable int rno) {
        return studentService.getstdByrnoAdvance(rno)   // Optional<Student>
                .map(student -> ResponseEntity.ok(student))  // wrap in ResponseEntity
                .orElse(ResponseEntity.notFound().build());  // return 404 if empty
    }

    //we cannot have mapping of same path for same type of mapping only
    //here we are using postmapping so we can use same path
    @PostMapping("student")
    public String addStudent(@RequestBody Student student){
        studentService.addStudent(student);
        return "sucessfully added";
    }

    @PutMapping("/student")
    public String updateStudentbasic(@RequestBody Student student){
        studentService.updateStudent(student);
        return "sucessfull updation";
    }

    @PutMapping("/student4")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student) {
        return studentService.getstdByrnoAdvance(student.getRoll()) // Optional<Student>
                .map(existing -> {
                    Student updated = studentService.updateStudent(student);
                    return ResponseEntity.ok(updated);
                })
                .orElse(ResponseEntity.notFound().build()); // 404 if not found
    }

    @DeleteMapping("/student/{rno}")
    public String deleteStudent(@PathVariable("rno") int rno){
        return studentService.deleteStudent(rno);
    }




}
