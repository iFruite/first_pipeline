package com.bytheone.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * 商机 实体类
 * - 针对简历等商机
 * - id 不可以重复
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class SysSource implements Serializable {

    private String id = null;

    private String name = null;

    private String mobile = null;

    private String age = null;

    private String gender = null;

    /**
     * 学历，学位
     */
    private String degree = null;

    private String school = null;

    private String hukou = null;

    private String location = null;

    private String email = null;

    private String education = null;

    private String career = null;

    private String project = null;

    private String skills = null;

    private Byte sourceType = null;

    private String position = null;

    private String remark = null;

    private String url = null;

    private Byte status = null;

    private Date receiveDate = null;

    private String createBy = null;

    private Date createDate = null;

    private String updateBy = null;

    private Date updateDate = null;

    private String permission = null;

    private String priority = null;

    private String sourceDetail = null;

    private Date graduateDate = null;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getHukou() {
        return hukou;
    }

    public void setHukou(String hukou) {
        this.hukou = hukou;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    public Byte getSourceType() {
        return sourceType;
    }

    public void setSourceType(Byte sourceType) {
        this.sourceType = sourceType;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String applyPosition) {
        this.position = applyPosition;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }
}
