package com.bytheone.service;

import com.bytheone.base.BaseService;
import com.bytheone.entity.SysRole;

import java.util.List;

/**
 * @author ArtLinty
 * @date 2017/12/19.
 * @email liu.tingli@qq.com
 */
public interface RoleService extends BaseService<SysRole, String> {

    @Override
    int deleteByPrimaryKey(String id);

    @Override
    int insert(SysRole record);

    @Override
    int insertSelective(SysRole record);

    @Override
    SysRole selectByPrimaryKey(String id);

    @Override
    int updateByPrimaryKeySelective(SysRole record);

    @Override
    int updateByPrimaryKey(SysRole record);

    List<SysRole> selectListByPage(SysRole sysRole);
}
