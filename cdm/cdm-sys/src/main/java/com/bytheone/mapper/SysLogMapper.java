package com.bytheone.mapper;

import com.bytheone.base.BaseMapper;
import com.bytheone.entity.SysLog;

import java.util.List;

public interface SysLogMapper extends BaseMapper<SysLog, String> {
    int deleteByPrimaryKey(Integer id);

    int insert(SysLog record);

    int insertSelective(SysLog record);

    SysLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysLog record);

    int updateByPrimaryKey(SysLog record);

    List<SysLog> selectListByPage(SysLog sysLog);
}