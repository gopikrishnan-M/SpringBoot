package com.example.thymeLeaf.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MessageController {

    //handler method to handle helloworld request
    //http://localhost:8080/helloworld

    @GetMapping("helloworld")
    public String helloWorld(Model model){
        model.addAttribute("message","Hello guys");
        return "Hello-World";
    }
}
/*
* Thymeleaf Standard Expressions
Five types of Thymeleaf standard expressions:
1.${...} : Variable expressions
2.*{...} : selection expressions
3.#{...} : message (il8n) expressions
4.@{...} : link (url) expressions
5.~{...} : fragment expressions
*/
