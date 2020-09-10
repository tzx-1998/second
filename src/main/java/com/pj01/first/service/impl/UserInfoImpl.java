package com.pj01.first.service.impl;

import com.pj01.first.mapper.UserMapper;
import com.pj01.first.model.*;
import com.pj01.first.service.IUserInfoService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class UserInfoImpl  implements IUserInfoService {
    @Resource
    UserMapper userMapper;
    public PageResult<User> findPageResult(User condition, Integer page, Integer limit) {
        PageResult<User> result = new PageResult<User>();
        result.setCode(0);
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("start", (page - 1) * limit);
        params.put("pageSize", limit);
        int totalCount = userMapper.findUserCountByMap(params);
        result.setCount(totalCount);
        List<User> list = userMapper.findUserInfoListByMap(params);
        result.setData(list);
        return result;
    }

    @Override
    public void save(User user) {
        userMapper.insert(user);
    }

    @Override
    public PageResult<Program> findOptionByUsername(Program program, int page, int limit, String username) {
        PageResult<Program> result = new PageResult<Program>();
        result.setCode(0);
        Map<String,Object> params = new HashMap<String,Object>();
        int totalCount = userMapper.findUserOptionCount(params,username);
        result.setCount(totalCount);
        List<Program> list = userMapper.findThisUserOption(params,username);
        result.setData(list);
        return result;
    }

    @Override
    public void saveNewOption(String thisname, String id) {
         userMapper.insertNewOption(thisname,id);
    }

    @Override
    public void deleteOption(String thisname, String id) {
        userMapper.deleteOption(thisname,id);
    }

    @Override
    public void deleteThisUser(String username) {
        userMapper.deleteThisUser(username);
        userMapper.deleteUserOption(username);
    }

    @Override
    public void update(List<String> id,String username) {
        int[] temp1 = new int[10];
        int[] temp2 = new int[10];
        for(int i=0;i<10;i++){
            temp1[i] = 0;
            temp2[i] = 0;
        }
        List find = userMapper.findOption(username);
        for(int i=0;i<find.size();i++){
            Object t = find.get(i);
            temp1[(int) t] = 1;
        }
        System.out.println(temp1);
        for (int i=0;i<id.size();i++){
             int t = Integer.parseInt(id.get(i));
            temp2[t] = 1;
        }
        for(int i=1;i<10;i++){
            if (temp1[i]==1&&temp2[i]==0){
                String t =String.valueOf(i);
                userMapper.deleteOption(username,t);
            }else if(temp1[i]==0&&temp2[i]==1){
                String t =String.valueOf(i);
                userMapper.insertNewOption(username,t);
            }
        }
    }
}
