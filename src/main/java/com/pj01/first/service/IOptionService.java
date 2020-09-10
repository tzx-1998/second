package com.pj01.first.service;

import com.pj01.first.model.Authority;
import com.pj01.first.model.PageResult;
import com.pj01.first.model.Program;

public interface IOptionService {
    public PageResult<Program> findPageResult(Program conditon,int page, int pageSize,String username);

    public void save(Program program);

    public PageResult<Program> findAllOption(Program condition,int page,int pageSize);

    public void deleteByOrderId(String id);
}
