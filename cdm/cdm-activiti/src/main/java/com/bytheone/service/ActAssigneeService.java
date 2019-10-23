package com.bytheone.service;

import com.bytheone.base.BaseService;
import com.bytheone.entity.ActAssignee;
import org.activiti.engine.impl.pvm.process.ActivityImpl;

import java.util.List;

/**
 * @author ArtLinty
 * @date 2018/1/23.
 * @email liu.tingli@qq.com
 */
public interface ActAssigneeService extends BaseService<ActAssignee, String> {
    int deleteByNodeId(String nodeId);

    public List<ActivityImpl> getActivityList(String deploymentId);

    public List<ActivityImpl> selectAllActivity(List<ActivityImpl> activities);

}
