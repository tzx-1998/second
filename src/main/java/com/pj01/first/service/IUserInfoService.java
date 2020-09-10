package com.pj01.first.service;

import com.pj01.first.model.*;

import java.util.List;

public interface IUserInfoService {
    public PageResult<User> findPageResult(User condition, Integer page, Integer limit);

    public void save(User user);

    public PageResult<Program> findOptionByUsername(Program program, int page, int limit, String username);

    void saveNewOption(String thisname, String id);

    void deleteOption(String thisname, String id);

    void deleteThisUser(String username);

    void update(List<String> id,String username);
}
