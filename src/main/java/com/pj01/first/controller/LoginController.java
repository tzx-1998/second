package com.pj01.first.controller;

import com.pj01.first.model.User;
import com.pj01.first.service.ICourseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.net.ssl.HandshakeCompletedEvent;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
public class LoginController {
    @Resource
    HttpServletRequest request;
    @Resource
    HttpSession session;

    @Autowired
    ICourseOrderService orderService;

    @RequestMapping("/login")
    public String login() {
        Object test =  session.getAttribute("username");
        if(test!=null){
            request.getSession().removeAttribute("username");
        }
        return "login";
    }

    @RequestMapping("/submit")
    public String submit(User user) {
        if (orderService.compare(user.username, user.password)) {
            session.setAttribute("username", user.username);
            return "/index";
        } else {
            return "/login";
        }

    }

}
