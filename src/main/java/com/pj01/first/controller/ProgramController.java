package com.pj01.first.controller;

import com.pj01.first.model.*;
import com.pj01.first.service.ICourseOrderService;
import com.pj01.first.service.IOptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.plugin.dom.core.Element;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/progadmin")
public class ProgramController {
    @Resource
    HttpServletRequest request;
    @Resource
    HttpSession session;
    @Autowired
    IOptionService optionService;

    @RequestMapping("/prog")
    public String program() {
        return "/progadmin/prog";
    }
    @RequestMapping("/add")
    public String add(){
        return "/progadmin/add";
    }
    @RequestMapping("/save")
    @ResponseBody
    public CURDResult save(Program program){
        CURDResult result = new CURDResult();
        optionService.save(program);
        return result;
    }
    @RequestMapping("/delete")
    @ResponseBody
    public CURDResult delete(String id){
        CURDResult result = new CURDResult();
        optionService.deleteByOrderId(id);
        return result;
    }
    @RequestMapping("/listJson")
    @ResponseBody
    public PageResult<Program> listJson() {
        String username = (String) session.getAttribute("username");
        PageResult<Program> result = optionService.findPageResult(null, 1, 20, username);
        return result;
    }
    @RequestMapping("/AlllistJson")
    @ResponseBody
    public PageResult<Program> AlllistJson() {
        PageResult<Program> result = optionService.findAllOption(null, 1, 20);
        return result;
    }
}
