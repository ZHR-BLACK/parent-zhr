package com.zhr.db.dao.table;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @创建人 zhangjing710
 * @创建时间 2021/3/3 10:30
 * @描述 待处理任务表
 */
@Data
@TableName("t_task")
public class TtaskDo {

    /**
     * 主键id
     */
    private Long id;
    /**
     * 参数
     */
    private String param;
    /**
     * 方法名称
     */
    private String methodName;
    /**
     * 任务标识
     */
    private int taskMark;
    /**
     * 是否处理
     */
    private int hasDeal;
    /**
     * 数据创建时间
     */
    private LocalDateTime createDate;
    /**
     * 数据创建时间
     */
    private LocalDateTime updateTime;

}
