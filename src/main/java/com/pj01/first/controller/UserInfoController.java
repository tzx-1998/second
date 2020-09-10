package com.pj01.first.controller;

import com.pj01.first.model.*;
import com.pj01.first.service.IUserInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.lang.reflect.Array;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserInfoController {
    public String thisname;
    @Resource
    IUserInfoService userInfoService;

    @RequestMapping("/userinfo")
    public String userinfo() {
        return "/user/userinfo";
    }

    @RequestMapping("/add")
    public String add() {
        return "/user/add";
    }

    @RequestMapping("/test")
    public String test(String username) {
        thisname = username;
        return "/user/test";
    }

    @RequestMapping("/addOption")
    public String addOption() {
        return "/user/addOption";
    }

    @RequestMapping("/change")
    public String change(String username) {
        thisname = username;
        return "/user/change";
    }

    @RequestMapping("/save")
    @ResponseBody
    public CURDResult save(User user) {
        CURDResult result = new CURDResult();
        userInfoService.save(user);
        return result;
    }
    @RequestMapping("/update")
    @ResponseBody
    public CURDResult update(@RequestBody  List<String> ID) {
        CURDResult result = new CURDResult();
        userInfoService.update(ID,thisname);
        return result;
    }

    @RequestMapping("/delete")
    @ResponseBody
    public CURDResult delete(String username) {
        CURDResult result = new CURDResult();
        userInfoService.deleteThisUser(username);
        return result;
    }

    @RequestMapping("/listJson")
    @ResponseBody
    public PageResult<User> listJson(User condition, Integer page, Integer limit) {
        PageResult<User> result = userInfoService.findPageResult(condition, page, limit);
        return result;
    }

    @RequestMapping("/thisUserOptionJson")
    @ResponseBody
    public PageResult<Program> findOption() {
        PageResult<Program> result = userInfoService.findOptionByUsername(null, 1, 20, thisname);
        return result;
    }

    @RequestMapping("/saveNewOption")
    @ResponseBody
    public CURDResult saveNew(String id) {
        CURDResult result = new CURDResult();
        userInfoService.saveNewOption(thisname, id);
        return result;
    }
    @RequestMapping("/deleteOption")
    @ResponseBody
    public CURDResult deleteOption(String id) {
        CURDResult result = new CURDResult();
        userInfoService.deleteOption(thisname, id);
        return result;
    }


}
