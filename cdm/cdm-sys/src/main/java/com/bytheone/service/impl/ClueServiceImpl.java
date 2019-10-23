package com.bytheone.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.bytheone.base.BaseMapper;
import com.bytheone.base.impl.BaseServiceImpl;
import com.bytheone.entity.SysClue;
import com.bytheone.mapper.SysClueMapper;
import com.bytheone.service.ClueService;
import com.bytheone.service.SysUserService;
import com.bytheone.util.TreeUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;


/**
 * @author ArtLinty
 * @date 2017/12/12.
 * @email liu.tingli@qq.com
 */
@Service
public class ClueServiceImpl extends BaseServiceImpl<SysClue, String> implements ClueService {

    @Autowired
    private SysClueMapper clueDao;

    @Override
    public BaseMapper<SysClue, String> getMapper() {
        return clueDao;
    }

    @Override
    public int insert(SysClue clue) {
        return clueDao.insert(clue);
    }

    @Override
    public SysClue selectByPrimaryKey(String id) {
        return clueDao.selectByPrimaryKey(id);
    }


}
