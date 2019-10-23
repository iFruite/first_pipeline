package com.bytheone.service;

import com.bytheone.base.BaseService;
import com.bytheone.entity.SysRoleUser;

import java.util.List;

/**
 * @author ArtLinty
 * @date 2017/12/21.
 * @email liu.tingli@qq.com
 */
public interface RoleUserService extends BaseService<SysRoleUser, String> {

    int deleteByPrimaryKey(SysRoleUser sysRoleUser);

    int insert(SysRoleUser sysRoleUser);

    int selectCountByCondition(SysRoleUser sysRoleUser);

    List<SysRoleUser> selectByCondition(SysRoleUser sysRoleUser);
}
