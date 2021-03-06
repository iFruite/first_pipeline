package com.bytheone.service.impl;

import com.bytheone.base.BaseMapper;
import com.bytheone.base.impl.BaseServiceImpl;
import com.bytheone.entity.ActAssignee;
import com.bytheone.mapper.ActAssigneeMapper;
import com.bytheone.service.ActAssigneeService;
import org.activiti.bpmn.converter.BpmnXMLConverter;
import org.activiti.bpmn.model.BpmnModel;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.impl.RepositoryServiceImpl;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.activiti.engine.impl.pvm.process.ActivityImpl;
import org.activiti.engine.impl.util.io.InputStreamSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ArtLinty
 * @date 2018/1/23.
 * @email liu.tingli@qq.com
 */
@Service
public class ActAssigneeServiceImpl extends BaseServiceImpl<ActAssignee, String> implements
        ActAssigneeService {

    @Autowired
    ActAssigneeMapper actAssigneeMapper;

    @Autowired
    private RepositoryService repositoryService;

    @Override
    public BaseMapper<ActAssignee, String> getMapper() {
        return actAssigneeMapper;
    }

    @Override
    public int deleteByNodeId(String nodeId) {
        return actAssigneeMapper.deleteByNodeId(nodeId);
    }

    @Override
    public List<ActivityImpl> getActivityList(String deploymentId) {
        org.activiti.engine.repository.ProcessDefinition processDefinition = repositoryService
                .createProcessDefinitionQuery().deploymentId(deploymentId).singleResult();
        ProcessDefinitionEntity processDefinitionEntity = (ProcessDefinitionEntity) ((RepositoryServiceImpl) repositoryService)
                .getDeployedProcessDefinition(processDefinition.getId());
        InputStream inputStream = repositoryService.getResourceAsStream(processDefinition.getDeploymentId(), processDefinition.getResourceName());
        BpmnModel bm = new BpmnXMLConverter().convertToBpmnModel(new InputStreamSource(inputStream), false, true);
        return selectAllActivity(processDefinitionEntity.getActivities());

    }

    @Override
    public List<ActivityImpl> selectAllActivity(List<ActivityImpl> activities) {
        List<ActivityImpl> list = new ArrayList<>(activities);
        for (ActivityImpl activity : activities) {
            List<ActivityImpl> childActivities = activity.getActivities();
            if (!childActivities.isEmpty()) {
                list.addAll(selectAllActivity(childActivities));
            }
        }
        return list;
    }
}
