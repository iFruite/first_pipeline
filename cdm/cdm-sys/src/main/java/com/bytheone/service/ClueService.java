package com.bytheone.service;

import com.alibaba.fastjson.JSONArray;
import com.bytheone.base.BaseService;
import com.bytheone.entity.SysClue;

import java.util.List;


/**
 * @author ArtLinty
 * @date 2017/12/12.
 * @email liu.tingli@qq.com
 */
public interface ClueService extends BaseService<SysClue, String> {

    @Override
    int insert(SysClue clue);

    @Override
    SysClue selectByPrimaryKey(String id);

}
