package com.pj01.first.service.impl;

import com.pj01.first.mapper.CourseOrderMapper;
import com.pj01.first.model.*;
import com.pj01.first.service.ICourseOrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CourseOrderServiceImpl implements ICourseOrderService {
    @Resource
    CourseOrderMapper orderMapper;

    @Override
    public PageResult<CourseOrder> findPageResult(CourseOrder condition, int page, int limit) {
        PageResult<CourseOrder> result = new PageResult<CourseOrder>();
        result.setCode(0);
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("condition", condition);
        params.put("start", (page - 1) * limit);
        params.put("pageSize", limit);
        //获取总记录数
        int totalCount = orderMapper.findCountByMap(params);
        result.setCount(totalCount);
        List<CourseOrder> list = orderMapper.findListByMap(params);
        result.setData(list);

        return result;
    }

    @Override
    public void save(CourseOrder order) {
        orderMapper.insert(order);
    }

    @Override
    public CourseOrder findByOrderId(String order_id) {
        return orderMapper.findByOrderId(order_id);
    }

    @Override
    public void deleteByOrderId(String order_id) {
        orderMapper.deleteByOrderId(order_id);
    }

    @Override
    public void update(CourseOrder order) {
        orderMapper.update(order);
    }

    @Override
    public List<Monthincome> getMonthIncomes() {
        return orderMapper.getMonthIncomes();
    }

    @Override
    public boolean compare(String username, String password) {
        User user = orderMapper.queryByUserNameAndPwd(username, password);
        if (user == null) {
            return false;
        }
        return true;
    }




}
