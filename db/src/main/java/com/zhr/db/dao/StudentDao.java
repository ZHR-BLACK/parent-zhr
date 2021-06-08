package com.zhr.db.dao;

import com.zhr.db.dao.table.StudentDo;

import java.util.List;

/**
 * @创建人 zhangjing710
 * @创建时间 2021/2/9 15:26
 * @描述
 */
public interface StudentDao {

    /**
     * 查出所有数据id列表
     * @return
     */
    List<Long> selectAllId();

    /**
     * 去重并分页
     * @param startPage
     * @param pageSize
     * @return
     */
    List<StudentDo> selectPhoneForPage(int startPage, int pageSize);

    /**
     * 批量添加或修改
     * @param studentDoList
     * @return
     */
    boolean batchInsertOrUpdate(List<StudentDo> studentDoList);

}
