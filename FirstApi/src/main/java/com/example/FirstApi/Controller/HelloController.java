package com.example.FirstApi.Controller;

import com.example.FirstApi.Service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {


    @Autowired
    HelloService helloService;

    //this getmapping will map the page to differetn directry -"/" represents home page
    @GetMapping("/hello")
    public String greeting(){
        return helloService.greet();
    }

    @GetMapping("/about")
    public String aboutUs(){
        return "semicolon savages";
    }
}
