package com.pj01.first.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/stuinfo")
public class StudentinfoController {
    @RequestMapping("/list")
    public String index(){
        return "stuinfo/list";
    }
}
