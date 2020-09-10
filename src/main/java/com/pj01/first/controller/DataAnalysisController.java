package com.pj01.first.controller;

import com.pj01.first.model.Monthincome;
import com.pj01.first.service.ICourseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/dataanalysis")
public class DataAnalysisController {
    @Autowired
    ICourseOrderService orderService;
    @RequestMapping("/income")
    public String income(){
        return "dataanalysis/income";
    }
    @RequestMapping("monthincome")
    @ResponseBody
    public List<Monthincome> monthIncomes(){
        List<Monthincome> list = orderService.getMonthIncomes();
        return list;
    }
}
