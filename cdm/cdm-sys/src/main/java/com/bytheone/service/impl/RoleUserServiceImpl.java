package com.bytheone.service.impl;

import com.bytheone.base.BaseMapper;
import com.bytheone.base.impl.BaseServiceImpl;
import com.bytheone.entity.SysRoleUser;
import com.bytheone.mapper.SysRoleUserMapper;
import com.bytheone.service.RoleUserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ArtLinty
 * @date 2017/12/21.
 * @email liu.tingli@qq.com
 */
@Service
public class RoleUserServiceImpl extends BaseServiceImpl<SysRoleUser, String> implements
        RoleUserService {

    @Autowired
    private SysRoleUserMapper sysRoleUserMapper;

    @Override
    public BaseMapper<SysRoleUser, String> getMapper() {
        return sysRoleUserMapper;
    }

    @Override
    public int deleteByPrimaryKey(SysRoleUser sysRoleUser) {
        return sysRoleUserMapper.deleteByPrimaryKey(sysRoleUser);
    }

    @Override
    public int selectCountByCondition(SysRoleUser sysRoleUser) {
        return sysRoleUserMapper.selectCountByCondition(sysRoleUser);
    }

    @Override
    public List<SysRoleUser> selectByCondition(SysRoleUser sysRoleUser) {
        return sysRoleUserMapper.selectByCondition(sysRoleUser);
    }
}
