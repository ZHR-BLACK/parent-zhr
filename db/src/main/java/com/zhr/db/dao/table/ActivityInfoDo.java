package com.zhr.db.dao.table;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @创建人 zhangjing710
 * @创建时间 2021/1/7 14:49
 * @描述 活动白名单相关信息表
 */
@Data
@TableName("activity_info")
public class ActivityInfoDo {

    /**
     * 主键id
     */
    private Long id;
    /**
     * 账号 手机号
     */
    private String phone;
    /**
     * 店铺名称
     */
    private String shopName;
    /**
     * 活动id
     */
    private Long activityId;
    /**
     * 数据创建时间
     */
    private LocalDateTime createDate;
    /**
     * 数据创建时间
     */
    private LocalDateTime updateTime;
    /**
     * 平生侧主pin
     */
    private String bpin;
    /**
     * 是否被查出来
     */
    private int hasHidden;

}
