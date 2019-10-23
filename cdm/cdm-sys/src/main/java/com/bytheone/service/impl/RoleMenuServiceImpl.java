package com.bytheone.service.impl;

import com.bytheone.base.BaseMapper;
import com.bytheone.base.impl.BaseServiceImpl;
import com.bytheone.entity.SysRoleMenu;
import com.bytheone.mapper.SysRoleMenuMapper;
import com.bytheone.service.RoleMenuService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ArtLinty
 * @date 2017/12/28.
 * @email liu.tingli@qq.com
 */
@Service
public class RoleMenuServiceImpl extends BaseServiceImpl<SysRoleMenu, String> implements
        RoleMenuService {
    @Autowired
    private SysRoleMenuMapper roleMenuMapper;

    @Override
    public BaseMapper<SysRoleMenu, String> getMapper() {
        return roleMenuMapper;
    }

    @Override
    public List<SysRoleMenu> selectByCondition(SysRoleMenu sysRoleMenu) {
        return roleMenuMapper.selectByCondition(sysRoleMenu);
    }

    @Override
    public int selectCountByCondition(SysRoleMenu sysRoleMenu) {
        return roleMenuMapper.selectCountByCondition(sysRoleMenu);
    }

    @Override
    public int deleteByPrimaryKey(SysRoleMenu sysRoleMenu) {
        return roleMenuMapper.deleteByPrimaryKey(sysRoleMenu);
    }
}
