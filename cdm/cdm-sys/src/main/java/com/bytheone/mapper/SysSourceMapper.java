package com.bytheone.mapper;

import com.bytheone.base.BaseMapper;
import com.bytheone.entity.SysSource;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Source Mapper
 */
public interface SysSourceMapper extends BaseMapper<SysSource, String> {

    @Override
    int deleteByPrimaryKey(String id);

    @Override
    int insert(SysSource record);

    @Override
    int insertSelective(SysSource record);

    @Override
    SysSource selectByPrimaryKey(String id);

    @Override
    int updateByPrimaryKeySelective(SysSource record);

    @Override
    int updateByPrimaryKey(SysSource record);


}