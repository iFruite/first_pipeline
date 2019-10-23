package com.bytheone.service;


import com.bytheone.base.BaseService;
import com.bytheone.entity.SysRoleUser;
import com.bytheone.entity.SysUser;
import com.bytheone.util.Checkbox;
import com.bytheone.util.JsonUtil;

import java.util.List;

/**
 * @author ArtLinty
 * @date 2017/12/4.
 * @email liu.tingli@qq.com
 */
public interface SysUserService extends BaseService<SysUser, String> {

    SysUser login(String username);

    @Override
    SysUser selectByPrimaryKey(String id);

    /**
     * 分页查询
     *
     * @param
     * @return
     */
    List<SysUser> selectListByPage(SysUser sysUser);

    int count();

    /**
     * 新增
     *
     * @param user
     * @return
     */
    int add(SysUser user);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    JsonUtil delById(String id, boolean flag);

    int checkUser(String username);


    int updateByPrimaryKey(SysUser sysUser);

    List<SysRoleUser> selectByCondition(SysRoleUser sysRoleUser);

    public List<Checkbox> getUserRoleByJson(String id);

    /**
     * 更新密码
     *
     * @param user
     * @return
     */
    int rePass(SysUser user);

}
