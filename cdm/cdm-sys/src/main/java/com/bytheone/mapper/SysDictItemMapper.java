package com.bytheone.mapper;

import com.bytheone.base.BaseMapper;
import com.bytheone.entity.SysDictItem;

public interface SysDictItemMapper extends BaseMapper<SysDictItem, String> {
    int deleteByPrimaryKey(String id);

    int insert(SysDictItem record);

    int insertSelective(SysDictItem record);

    SysDictItem selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SysDictItem record);

    int updateByPrimaryKey(SysDictItem record);
}