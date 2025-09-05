package com.example.thymeLeaf.Controller;

import com.example.thymeLeaf.Model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("variableExpression")
    public String variableExpression(Model model){
        User user1=new User(21,"kris","zirk@gmail.com");
        model.addAttribute("user",user1);
        return "Variable-expression";//this should be the name for thymeleaf template file
    }
    @GetMapping("selectionExpression")
    public String selectionExpression(Model model){
        User user1=new User(21,"zirk","kris@gmail.com");
        model.addAttribute("userselect",user1);
        return "Selection-expression";//this should be the name for thymeleaf template file
    }

    @GetMapping("messageExpression")
    public String messageExpression(){
        return "Message-Expression";
    }

    @GetMapping("linkExpression")
    public String linkExpression(){
        return "Link-Expression";
    }
    @GetMapping("linkExpressionParam")
    public String linkExpressionParam(Model model){
        model.addAttribute("id",1);
        return "Link-ExpressionParam";
    }
}
