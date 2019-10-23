package com.bytheone.mapper;

import com.bytheone.base.BaseMapper;
import com.bytheone.entity.SysClue;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * SysClueMapper
 *
 * @author ArtLinty
 * @date 2018-06-17
 */
public interface SysClueMapper extends BaseMapper<SysClue, String> {

    @Override
    int deleteByPrimaryKey(String id);

    @Override
    int insert(SysClue record);

    @Override
    int insertSelective(SysClue record);

    @Override
    SysClue selectByPrimaryKey(String id);

    @Override
    int updateByPrimaryKeySelective(SysClue record);

    @Override
    int updateByPrimaryKey(SysClue record);



}