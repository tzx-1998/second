package com.pj01.first.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/courseorder")
public class CourseOrderController {
    @RequestMapping("/list")
    public String index(){
        return "courseorder/list";
    }
}
