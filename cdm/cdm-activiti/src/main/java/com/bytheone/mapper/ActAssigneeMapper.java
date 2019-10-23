package com.bytheone.mapper;

import com.bytheone.base.BaseMapper;
import com.bytheone.entity.ActAssignee;

public interface ActAssigneeMapper extends BaseMapper<ActAssignee, String> {
    int deleteByPrimaryKey(String id);

    int insert(ActAssignee record);

    int insertSelective(ActAssignee record);

    ActAssignee selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ActAssignee record);

    int updateByPrimaryKey(ActAssignee record);

    int deleteByNodeId(String nodeId);
}