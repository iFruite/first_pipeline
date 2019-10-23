package com.bytheone.entity;

import com.bytheone.validator.group.AddGroup;
import com.bytheone.validator.group.UpdateGroup;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class SysClue implements Serializable {
    private String id;

    @NotEmpty(message = "线索名称不能为空", groups = {AddGroup.class, UpdateGroup.class})
    private String name;

    private String pId;

    private String url;

    @Length(min = 1, max = 4, message = "序号长度不对")
    private Integer orderNum;

    private String icon;

    private String createBy;

    private Date createDate;

    private String updateBy;

    private Date updateDate;

    private String permission;

    private Byte clueType;
    /**
     * 线索排序id 填充线索展示id
     */
    private int num;

    private static final long serialVersionUID = 1L;


}