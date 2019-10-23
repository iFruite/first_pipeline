package com.bytheone.service.impl;

import com.bytheone.base.BaseMapper;
import com.bytheone.base.impl.BaseServiceImpl;
import com.bytheone.entity.UserLeave;
import com.bytheone.mapper.UserLeaveMapper;
import com.bytheone.service.UserLeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ArtLinty
 * @date 2018/1/21.
 * @email liu.tingli@qq.com
 */
@Service
public class UserLeaveServiceImpl extends BaseServiceImpl<UserLeave, String> implements
        UserLeaveService {

    @Autowired
    UserLeaveMapper userLeaveMapper;

    @Override
    public BaseMapper<UserLeave, String> getMapper() {
        return userLeaveMapper;
    }
}
