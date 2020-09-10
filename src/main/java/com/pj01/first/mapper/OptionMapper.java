package com.pj01.first.mapper;

import com.pj01.first.model.Program;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;
@Mapper
public interface OptionMapper {
    public int findOptionCountByMap(Map<String,Object > map,String username);
    public List<Program> findOptionByMap(Map<String,Object > map,String username);

    public void insert(Program program);

    public int findAlloptionCount(Map<String, Object> params);

    List<Program> findAlloption(Map<String, Object> params);

    void deleteByOptionId(String id);
}
