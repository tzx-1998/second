package com.pj01.first.mapper;

import com.pj01.first.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;
@Mapper
public interface UserMapper {
    int findUserCountByMap(Map<String, Object> map);

    List<User> findUserInfoListByMap(Map<String, Object> map);

    void insert(User user);

    int findUserOptionCount(Map<String, Object> params, String username);

    List<Program> findThisUserOption(Map<String, Object> params, String username);

    void insertNewOption(String thisname, String id);

    void deleteOption(String thisname, String id);

    void deleteThisUser(String username);

    void deleteUserOption(String username);

   List findOption(String username);
}
