package com.bytheone.service.impl;

import com.bytheone.base.BaseMapper;
import com.bytheone.base.impl.BaseServiceImpl;
import com.bytheone.entity.SysDictType;
import com.bytheone.mapper.SysDictTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author ArtLinty
 * @date 2018/5/10.
 * @email liu.tingli@qq.com
 */
public class SysDictTypeServiceImpl extends BaseServiceImpl<SysDictType, String> {

    @Autowired
    private SysDictTypeMapper sysDictTypeMapper;

    @Override
    public BaseMapper<SysDictType, String> getMapper() {
        return sysDictTypeMapper;
    }
}
