package com.zhr.db.bean;

import lombok.Data;

/**
 * @创建人 zhangjing710
 * @创建时间 2021/3/1 16:47
 * @描述
 */
@Data
public class WhiteListQuery extends PageBase{

    /**
     * 活动id
     */
    private Long activityId;
    /**
     * 是否展示临时数据   0-不展示   1-展示
     */
    private int hasShow = 0;

}
