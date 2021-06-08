package com.zhr.db.dao;


import com.zhr.db.dao.table.TtaskDo;

import java.util.List;

/**
 * @创建人 zhangjing710
 * @创建时间 2021/3/3 10:47
 * @描述
 */
public interface TtaskDao {

    /**
     * 添加数据
     * @param ttaskDo
     * @return
     */
    Long saveTtask(TtaskDo ttaskDo);

    /**
     * 批量添加或修改
     * @param ttaskDoList
     * @return
     */
    boolean batchSaveOrUpdate(List<TtaskDo> ttaskDoList);

    List<TtaskDo> selectByTaskMark(int taskMark);


    List<TtaskDo> selectLastByMethodName(List<String> methodNameList);

}
