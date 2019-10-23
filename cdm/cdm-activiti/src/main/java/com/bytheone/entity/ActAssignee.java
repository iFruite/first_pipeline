/**
 * Copyright 2018 lenos
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.bytheone.entity;

import java.io.Serializable;

/**
 * @author ArtLinty
 * @date 2018/1/22.
 * @email liu.tingli@qq.com
 * <p>
 * 任务节点和代理人、候选人、候选组的绑定实体
 */
public class ActAssignee implements Serializable {
    private String id;

    private String sid;

    private String assignee;

    private String roleId;

    private Integer assigneeType;

    private String activtiName;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid == null ? null : sid.trim();
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee == null ? null : assignee.trim();
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    public Integer getAssigneeType() {
        return assigneeType;
    }

    public void setAssigneeType(Integer assigneeType) {
        this.assigneeType = assigneeType;
    }

    public String getActivtiName() {
        return activtiName;
    }

    public void setActivtiName(String activtiName) {
        this.activtiName = activtiName == null ? null : activtiName.trim();
    }

    public ActAssignee() {
    }

    public ActAssignee(String sid) {
        this.sid = sid;
    }
}