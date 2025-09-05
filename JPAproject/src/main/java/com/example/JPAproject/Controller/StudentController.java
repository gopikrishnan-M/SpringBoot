package com.example.JPAproject.Controller;

import com.example.JPAproject.Model.Student;
import com.example.JPAproject.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class StudentController {
    @Autowired
    StudentService studentService;

    //CREATE OR ADD
    @PostMapping("/student")
    public String addStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }

    //USE POST MAPPING FOR FILTERING when we use param then use postmapping
    //THERE INSTEAD OF @RequestParam we can even use @Param it works now but in the begining wut was the problem i dont
    //know this param,param at repo,=: symbol in sql, and lot are errors said by perplexity but all those works now🤣
    @PostMapping("student/filter")
    public List<Student> getStudentByGenderAndTechnology(
            @RequestParam("gender") String gender,
            @RequestParam("technology") String technology){
       return studentService.getStudentByGenderAndTechnology(gender,technology);
    }



    //READ DATA
    @GetMapping("/students")
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    //READ DATA WITH INPUT ROLL NUMBER
    @GetMapping("/student/{rno}")
    public ResponseEntity<Student> getStdByRoll(@PathVariable("rno") int roll){
        return studentService.getStdByRoll(roll)
                .map(ResponseEntity::ok)//.map(optinalStudent -> ResponseEntity.ok(optinalStudent))
                .orElse(ResponseEntity.notFound().build());
    }
    //GET STUDENT BY TECHNOLOGY -basic way
    @GetMapping("/student/tech/{tech}")
    public List<Student> getStudentsByTech(@PathVariable("tech") String technology){
        return studentService.getStudentsByTech(technology);
    }

    //GET STUDENT BY GENDER -basic way
    @GetMapping("/student/gender/{gender}")
    public List<Student> getStudentsByGender(@PathVariable("gender") String gender){
        return studentService.getStudentsByGender(gender);
    }

    //UPDATE DATA
    @PutMapping("/student")
    public ResponseEntity<String> updateByRoll(@RequestBody Student student){
        return studentService.getStdByRoll(student.getRoll())
                .map(optinalstudent ->{
                    studentService.updateByroll(student);
                    return ResponseEntity.ok("updated sucessfully...");
                        }
                )
                .orElse(ResponseEntity.ok("No student found with rno..."));
    }
    //UPDATE IF PRESENT ELSE ADD
    @PutMapping("/studentura")
    public String updateStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }

    //DELETE DATA SIMPLE
    @DeleteMapping("student/{rno}")
    public String deleteByRno(@PathVariable("rno") int roll){
        return studentService.getStdByRoll(roll)
                .map( optionalstudent -> {
                    studentService.deleteByRoll(roll);
                    return "Deleted successfully...";
                })
                .orElse("No Id found...");
    }

    //DELETE DATA RESPONSE ENTITY
    @DeleteMapping("studentr/{rno}")
    public ResponseEntity<String> deleteByRoll(@PathVariable("rno") int roll){
        return studentService.getStdByRoll(roll)
                .map( optionalstudent -> {
                    studentService.deleteByRoll(roll);
                    return ResponseEntity.ok("Deleted successfully...");
                })
                .orElse(ResponseEntity.ok("No Id found..."));
    }
    //DELETE DATA RESPONSE ENTITY
    @DeleteMapping("student4/{rno}")
    public ResponseEntity<String> deleteByRoll1(@PathVariable("rno") int roll){
        return studentService.getStdByRoll(roll)
                .map( optionalstudent -> {
                    studentService.deleteByRoll(roll);
                    return ResponseEntity.ok("Deleted successfully...");
                })
                .orElse(ResponseEntity.notFound().build());
    }


    //RESPONSE ENTITY 🤣

    //GET MAPPING
    @GetMapping("student/response/{rno}")
    public ResponseEntity<Student> getResponse(@PathVariable("rno") int roll){
        Student student=studentService.getStdByRollResponse(roll);
        if(student==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(student,HttpStatus.OK);
    }

    //POST MAPPING
    @PostMapping("student/response")
    public ResponseEntity<String> postResponse(@RequestBody Student student){
        studentService.addStudent(student);
        return new ResponseEntity<>("Added...",HttpStatus.CREATED);
    }

    //POST RESPONSE FOR JAVASCRIPT
    @PostMapping("add/student")
    public String addStudent(@RequestParam("roll") int rno,
                           @RequestParam("name") String name,
                           @RequestParam("gender") String gender,
                           @RequestParam("technology") String technology){
        studentService.addStudent(rno,name,gender,technology);
        return "Successfully fullStacked .....Keep going";
    }


}
