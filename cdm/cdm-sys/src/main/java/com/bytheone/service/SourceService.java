package com.bytheone.service;

import com.alibaba.fastjson.JSONArray;
import com.bytheone.base.BaseService;
import com.bytheone.entity.SysSource;

import java.util.List;


/**
 * @author ArtLinty
 * @date 2017/12/12.
 * @email liu.tingli@qq.com
 */
public interface SourceService extends BaseService<SysSource, String> {

    @Override
    int insert(SysSource source);

    @Override
    SysSource selectByPrimaryKey(String id);

    JSONArray getSourceJson(String id);

    int sync();

}
