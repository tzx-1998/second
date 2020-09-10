package com.pj01.first.service.impl;

import com.pj01.first.mapper.OptionMapper;
import com.pj01.first.model.PageResult;
import com.pj01.first.model.Program;
import com.pj01.first.service.IOptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OptionServiceImpl implements IOptionService {
    @Resource
    OptionMapper optionMapper;
    @Override
    public PageResult<Program> findPageResult(Program conditon, int page, int pageSize,String username) {
        PageResult<Program> result = new PageResult<Program>();
        result.setCode(0);
        Map<String, Object> params = new HashMap<String, Object>();
        int totalCount = optionMapper.findOptionCountByMap(params,username);
        result.setCount(totalCount);
        List<Program> list = optionMapper.findOptionByMap(params,username);
        result.setData(list);
        return result;
    }

    @Override
    public void save(Program program) {
        optionMapper.insert(program);
    }

    @Override
    public PageResult<Program> findAllOption(Program condition, int page, int pageSize) {
        PageResult<Program> result = new PageResult<Program>();
        result.setCode(0);
        Map<String,Object> params = new HashMap<String, Object>();
        int totalCount = optionMapper.findAlloptionCount(params);
        result.setCount(totalCount);
        List<Program> list = optionMapper.findAlloption(params);
        result.setData(list);
        return result;
    }

    @Override
    public void deleteByOrderId(String id) {
        optionMapper.deleteByOptionId(id);
    }
}
