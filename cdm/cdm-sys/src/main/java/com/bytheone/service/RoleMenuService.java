package com.bytheone.service;

import com.bytheone.base.BaseService;
import com.bytheone.entity.SysRoleMenu;

import java.util.List;

/**
 * @author ArtLinty
 * @date 2017/12/28.
 * @email liu.tingli@qq.com
 */
public interface RoleMenuService extends BaseService<SysRoleMenu, String> {

    List<SysRoleMenu> selectByCondition(SysRoleMenu sysRoleMenu);

    int selectCountByCondition(SysRoleMenu sysRoleMenu);

    int deleteByPrimaryKey(SysRoleMenu sysRoleMenu);
}
