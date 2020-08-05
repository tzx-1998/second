package com.pj01.first.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
    @RequestMapping("/index")
    public String index(){
        System.out.println("建国70周年");
        return "index";
    }
}
