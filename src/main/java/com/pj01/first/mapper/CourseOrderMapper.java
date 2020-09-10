package com.pj01.first.mapper;

import com.pj01.first.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface CourseOrderMapper {
    int findCountByMap(Map<String, Object> map);

    List<CourseOrder> findListByMap(Map<String, Object> map);

    void insert(CourseOrder order);

    public CourseOrder findByOrderId(String order_id);

    public void deleteByOrderId(String orderId);

    void update(CourseOrder order);

    public List<Monthincome> getMonthIncomes();

    User queryByUserNameAndPwd(String username, String password);


}
