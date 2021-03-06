package com.bytheone.mapper;

import com.bytheone.base.BaseMapper;
import com.bytheone.entity.SysJob;

public interface SysJobMapper extends BaseMapper<SysJob, String> {
    int deleteByPrimaryKey(String id);

    int insert(SysJob record);

    int insertSelective(SysJob record);

    SysJob selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SysJob record);

    int updateByPrimaryKey(SysJob record);
}