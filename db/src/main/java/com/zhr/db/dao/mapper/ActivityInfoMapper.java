package com.zhr.db.dao.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhr.db.dao.table.ActivityInfoDo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @创建人 zhangjing710
 * @创建时间 2021/1/7 14:54
 * @描述 数据库操作Mapper
 */
public interface ActivityInfoMapper extends BaseMapper<ActivityInfoDo> {

    /**
     * 保存应用实体
     *
     * @param activityInfoDo
     * @return 插入成功的自增主键id
     */
    @Insert("INSERT INTO activity_info " +
            "(" +
            "phone" +
            ",shop_name" +
            ",activity_id" +
            ",bpin" +
            ",has_hidden" +
            ",update_time" +
            ",create_date) " +
            "VALUES " +
            "(" +
            "#{phone}" +
            ",#{shopName}" +
            ",#{activityId}" +
            ",#{bpin}" +
            ",#{hasHidden}" +
            ",#{updateTime}" +
            ",#{createDate})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    Long saveActivityInfo(ActivityInfoDo activityInfoDo);

    @Select("select phone from activity_info where activity_id = #{activityId} GROUP BY phone;")
    List<String> selectPhoneByActivityId(Long activityId);

}
