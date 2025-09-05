package com.example.FirstApi.Service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Component for service we can specifically use @service but this also will work
@Service
public class HelloService {
    public String greet(){
        //buisness logic
        return "Hello guys";
    }
}
