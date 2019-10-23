package com.bytheone.mapper;

import com.bytheone.base.BaseMapper;
import com.bytheone.entity.SysRoleUser;

import java.util.List;

public interface SysRoleUserMapper extends BaseMapper<SysRoleUser, String> {

    int deleteByPrimaryKey(SysRoleUser key);

    int insert(SysRoleUser record);

    int insertSelective(SysRoleUser record);

    List<SysRoleUser> selectByCondition(SysRoleUser sysRoleUser);

    int selectCountByCondition(SysRoleUser sysRoleUser);
}