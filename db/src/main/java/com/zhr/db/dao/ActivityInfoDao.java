package com.zhr.db.dao;


import com.zhr.db.bean.WhiteListQuery;
import com.zhr.db.dao.table.ActivityInfoDo;

import java.util.List;

/**
 * @创建人 zhangjing710
 * @创建时间 2021/1/7 14:48
 * @描述 ActivityInfoDao
 */
public interface ActivityInfoDao {

    /**
     * 添加数据
     *
     * @param activityInfoDo
     * @return
     */
    Long saveActivityInfo(ActivityInfoDo activityInfoDo);

    /**
     * 批量添加或修改
     * @param activityInfoDoList
     * @return
     */
    boolean batchSaveOrUpdate(List<ActivityInfoDo> activityInfoDoList);

    /**
     * 根据id批量删除
     * @param ids
     * @return
     */
    int deleteBatchIds(List<Long> ids);

    /**
     * 根据activityId修改数据
     *
     * @param activityId
     * @return
     */
    boolean editActivityInfoByActivityId(Long activityId);

    /**
     * 根据activityId和hasHidden修改数据
     *
     * @param activityId
     * @param hasHidden
     * @return
     */
    boolean editActivityInfoByActivityIdAndHasHidden(Long activityId, int hasHidden);

    /**
     * 根据activityId查询表集合
     *
     * @param activityId
     * @return
     */
    List<ActivityInfoDo> selectActivityInfoListByActivityId(Long activityId);
    /**
     * 根据activityId查询表集合
     *
     * @param activityId
     * @return
     */
    List<ActivityInfoDo> selectAllActivityInfoListByActivityId(Long activityId);
    /**
     * 根据活动id和hasdden查询表集合
     * @param activityId
     * @param hasHidden
     * @return
     */
    List<ActivityInfoDo> selectActivityInfoListByActivityIdAndHashidden(Long activityId, int hasHidden);

    /**
     * 分页查询活动中的白名单列表按手机号去重
     *
     * @param whiteListQuery
     * @return
     */
    List<ActivityInfoDo> selectActivityInfoListByActivityIdAndPhoneForPage(WhiteListQuery whiteListQuery);

    /**
     * 根据活动id和手机号查询活动列表
     *
     * @param activityId,phoneList
     * @return
     */
    List<ActivityInfoDo> selectActivityInfoListByActivityIdAndPhone(Long activityId, List<String> phoneList);
    /**
     * 根据活动id和单个手机号查询活动列表
     *
     * @param activityId,phoneList
     * @return
     */
    List<ActivityInfoDo> selectActivityInfoListByActivityIdAndSinglePhone(Long activityId, String phone);
    /**
     * 根据活动id和单个手机号和bpin查询活动列表
     *
     * @param activityId,phoneList
     * @return
     */
    List<ActivityInfoDo> selectActivityInfoListByActivityIdAndSinglePhoneAndBpin(Long activityId, String phone, String bpin);

    /**
     * 根据活动id查询表中所有的手机号，去重后的
     * @param activityId
     * @return
     */
    List<String> selectPhoneByActivityId(Long activityId);
}
