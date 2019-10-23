package com.bytheone.service.impl;

import com.bytheone.base.BaseMapper;
import com.bytheone.base.impl.BaseServiceImpl;
import com.bytheone.entity.SysJob;
import com.bytheone.mapper.SysJobMapper;
import com.bytheone.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ArtLinty
 * @date 2018/1/6.
 * @email liu.tingli@qq.com
 */
@Service
public class JobServiceImpl extends BaseServiceImpl<SysJob, String> implements JobService {

    @Autowired
    SysJobMapper jobMapper;

    @Override
    public BaseMapper<SysJob, String> getMapper() {
        return jobMapper;
    }
}
