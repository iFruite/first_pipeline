package com.bytheone.base.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.bytheone.base.BaseMapper;
import com.bytheone.base.BaseService;
import com.bytheone.base.CurrentUser;
import com.bytheone.exception.MyException;
import com.bytheone.util.ReType;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author ArtLinty
 * @date 2017/12/13.
 * @email liu.tingli@qq.com
 */
@Slf4j
public abstract class BaseServiceImpl<T, E extends Serializable> implements BaseService<T, E> {

    /**
     * general field(通用字段)
     */
    private static final String CREATE_BY = "createBy";

    private static final String CREATE_DATE = "createDate";

    private static final String UPDATE_BY = "updateBy";

    private static final String UPDATE_DATE = "updateDate";

    //系统默认 id 如果主键为其他字段 则需要自己手动 生成 写入 id
    private static final String ID = "id";

    private static final String STR = "java.lang.String";

    public abstract BaseMapper<T, E> getMapper();

    @Override
    public int deleteByPrimaryKey(E id) {
        return getMapper().deleteByPrimaryKey(id);
    }

    @Override
    public int insert(T record) {
        record = addValue(record, true);
        return getMapper().insert(record);
    }

    /**
     * 通用注入创建 更新信息 可通过super调用
     *
     * @param record
     * @param flag
     * @return
     */
    public T addValue(T record, boolean flag) {
        CurrentUser currentUser = (CurrentUser) SecurityUtils.getSubject().getSession().getAttribute("curentUser");
        //统一处理公共字段
        Class<?> clazz = record.getClass();
        String operator, operateDate;
        try {
            if (flag) {
                //添加 id uuid支持
                Field idField = clazz.getDeclaredField(ID);
                idField.setAccessible(true);
                Object o = idField.get(record);
                Class<?> type = idField.getType();
                String name = type.getName();
                if ((o == null) && STR.equals(name)) {
                    //已经有值的情况下 不覆盖
                    idField.set(record, UUID.randomUUID().toString().replace("-", "").toLowerCase());
                }
                operator = CREATE_BY;
                operateDate = CREATE_DATE;
            } else {
                operator = UPDATE_BY;
                operateDate = UPDATE_DATE;
            }
            Field field = clazz.getDeclaredField(operator);
            field.setAccessible(true);
            field.set(record, currentUser.getId());
            Field fieldDate = clazz.getDeclaredField(operateDate);
            fieldDate.setAccessible(true);
            fieldDate.set(record, new Date());

        } catch (NoSuchFieldException e) {
            //无此字段
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return record;
    }

    @Override
    public int insertSelective(T record) {
        record = addValue(record, true);
        return getMapper().insertSelective(record);
    }

    @Override
    public T selectByPrimaryKey(E id) {
        return getMapper().selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(T record) {
        record = addValue(record, false);
        return getMapper().updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(T record) {
        record = addValue(record, false);
        return getMapper().updateByPrimaryKey(record);
    }

    @Override
    public List<T> selectListByPage(T record) {
        return getMapper().selectListByPage(record);
    }

    /**
     * 公共展示类
     *
     * @param t     实体
     * @param page  页
     * @param limit 行
     * @return
     */
    @Override
    public String show(T t, int page, int limit) {
        List<T> tList = null;
        Page<T> tPage = PageHelper.startPage(page, limit);
        try {
            tList = getMapper().selectListByPage(t);
        } catch (MyException e) {
//            logger.error("class:BaseServiceImpl ->method:show->message:" + e.getMessage());
            log.error("class:BaseServiceImpl ->method:show->message:" + e.getMessage());
            e.printStackTrace();
        }
        ReType reType = new ReType(tPage.getTotal(), tList);
        return JSON.toJSONString(reType);
    }

}
