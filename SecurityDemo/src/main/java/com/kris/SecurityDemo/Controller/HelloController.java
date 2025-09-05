/*
package com.kris.SecurityDemo.Controller;

import com.kris.SecurityDemo.Model.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class HelloController {
    List<Student> students=new ArrayList<>(Arrays.asList(
            new Student(12,"kris","janani"),
            new Student(21,"zirk","jana")
    ));

    @GetMapping("/")
    @ResponseBody
    public String  greet(HttpServletRequest request){
        String sessionId=request.getSession().getId();
        System.out.println("Greet involked");
        return "welcome to spring boot security" + sessionId;
    }
    @GetMapping("/session")
    public String GetSessionId(HttpServletRequest request){
        return request.getSession().getId();
    }

    @GetMapping("/token")
    public CsrfToken getCsrf(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }

    @GetMapping("/students")
    public List<Student> getStudents(){
        return students;
    }

    @PostMapping("/student")
    public Student postStudent(@RequestBody Student student){
        students.add(student);
        return student;
    }


}
*/
