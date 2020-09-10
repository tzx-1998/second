package com.pj01.first.service;

import com.pj01.first.model.CourseOrder;
import com.pj01.first.model.Monthincome;
import com.pj01.first.model.PageResult;
import com.pj01.first.model.Program;

import java.util.List;

public interface ICourseOrderService {
    public PageResult<CourseOrder> findPageResult(CourseOrder condition,int page,int limit);

    public void save(CourseOrder order);

    public CourseOrder findByOrderId(String order_id);

    public void deleteByOrderId(String orderId);

    public void update(CourseOrder order);

    public List<Monthincome> getMonthIncomes();

    public boolean compare(String username, String password);


}
