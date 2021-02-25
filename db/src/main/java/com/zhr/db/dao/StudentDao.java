package com.zhr.db.dao;

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

}
