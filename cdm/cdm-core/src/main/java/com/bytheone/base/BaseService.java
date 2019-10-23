package com.bytheone.base;

import java.io.Serializable;
import java.util.List;

/**
 * Base Service，通用 服务
 * @author ArtLinty
 * @date 2017/12/13.
 * @email liu.tingli@qq.com
 * 通用service层
 */
public interface BaseService<T, E extends Serializable> {
    /**
     * 根据主键id删除
     *
     * @param id：主键
     * @return int
     */
    int deleteByPrimaryKey(E id);

    /**
     * 插入记录
     *
     * @param record 记录
     * @return int
     */
    int insert(T record);

    /**
     * 插入非空字段
     *
     * @param record 记录
     * @return int
     */
    int insertSelective(T record);

    /**
     * 根据id查询
     *
     * @param id 主键Id
     * @return 对象
     */
    T selectByPrimaryKey(E id);

    /**
     * 更新非空数据
     *
     * @param record 记录
     * @return int
     */
    int updateByPrimaryKeySelective(T record);

    /**
     * 更新
     *
     * @param record 记录
     * @return int
     */
    int updateByPrimaryKey(T record);

    /**
     * 根据分页选择列表数据
     *
     * @param record 记录
     * @return 列表
     */
    List<T> selectListByPage(T record);

    /**
     * 显示记录
     *
     * @param t     对象
     * @param page  页面 int
     * @param limit 个数 int
     * @return String
     */
    String show(T t, int page, int limit);

}
