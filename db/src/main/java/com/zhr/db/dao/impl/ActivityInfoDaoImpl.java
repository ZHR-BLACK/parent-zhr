package com.zhr.db.dao.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhr.db.bean.WhiteListQuery;
import com.zhr.db.dao.ActivityInfoDao;
import com.zhr.db.dao.mapper.ActivityInfoMapper;
import com.zhr.db.dao.table.ActivityInfoDo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @创建人 zhangjing710
 * @创建时间 2021/1/7 14:53
 * @描述
 */
@Slf4j
@Component
public class ActivityInfoDaoImpl extends ServiceImpl<ActivityInfoMapper, ActivityInfoDo> implements ActivityInfoDao {

    @Override
    public Long saveActivityInfo(ActivityInfoDo activityInfoDo) {
        activityInfoDo.setCreateDate(LocalDateTime.now());
        activityInfoDo.setUpdateTime(LocalDateTime.now());
        this.baseMapper.saveActivityInfo(activityInfoDo);
        return activityInfoDo.getId();
    }

    @Override
    public boolean batchSaveOrUpdate(List<ActivityInfoDo> activityInfoDoList) {
        return this.saveOrUpdateBatch(activityInfoDoList, activityInfoDoList.size());
    }

    @Override
    public int deleteBatchIds(List<Long> ids) {
        return this.baseMapper.deleteBatchIds(ids);
    }

    @Override
    public boolean editActivityInfoByActivityId(Long activityId) {
        return false;
    }

    @Override
    public boolean editActivityInfoByActivityIdAndHasHidden(Long activityId, int hasHidden) {
        return false;
    }

//    @Override
//    public boolean editActivityInfoByActivityId(Long activityId) {
//        LambdaUpdateWrapper<ActivityInfoDo> updateWrapper = new LambdaUpdateWrapper<>();
//        updateWrapper.set(ActivityInfoDo::getHasHidden, 2);
//        updateWrapper.eq(ActivityInfoDo::getActivityId, activityId);
//        return this.update(updateWrapper);
//    }
//
//    @Override
//    public boolean editActivityInfoByActivityIdAndHasHidden(Long activityId, int hasHidden) {
//        LambdaUpdateWrapper<ActivityInfoDo> updateWrapper = new LambdaUpdateWrapper<>();
//        updateWrapper.set(ActivityInfoDo::getHasHidden, hasHidden);
//        updateWrapper.eq(ActivityInfoDo::getActivityId, activityId);
//        return this.update(updateWrapper);
//    }

    @Override
    public List<ActivityInfoDo> selectActivityInfoListByActivityId(Long activityId) {
        LambdaQueryWrapper<ActivityInfoDo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(ActivityInfoDo::getActivityId, activityId);
        // 1-查出来,当前数据   2-查不出来,过期数据
        queryWrapper.eq(ActivityInfoDo::getHasHidden, 1);
        return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    public List<ActivityInfoDo> selectAllActivityInfoListByActivityId(Long activityId) {
        LambdaQueryWrapper<ActivityInfoDo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(ActivityInfoDo::getActivityId, activityId);
        return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    public List<ActivityInfoDo> selectActivityInfoListByActivityIdAndHashidden(Long activityId, int hasHidden) {
        LambdaQueryWrapper<ActivityInfoDo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(ActivityInfoDo::getActivityId, activityId);
        // 1-查出来,当前数据   2-查不出来,过期数据
        queryWrapper.eq(ActivityInfoDo::getHasHidden, hasHidden);
        return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    public List<ActivityInfoDo> selectActivityInfoListByActivityIdAndPhoneForPage(WhiteListQuery whiteListQuery) {
        QueryWrapper<ActivityInfoDo> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("phone");
        queryWrapper.eq("activity_id", whiteListQuery.getActivityId());
        if (whiteListQuery.getHasShow() == 1) {
            queryWrapper.and(wrapper -> wrapper.eq("has_hidden", 1)
                    .or().eq("has_hidden", 4));
        } else {
            queryWrapper.eq("has_hidden", 1);
        }
        queryWrapper.orderByDesc("update_time");
        return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    public List<ActivityInfoDo> selectActivityInfoListByActivityIdAndPhone(Long activityId, List<String> phoneList) {
        LambdaQueryWrapper<ActivityInfoDo> queryWrapper = new LambdaQueryWrapper<>();
        // 活动id
        if (activityId != null
                && activityId != 0) {
            queryWrapper.eq(ActivityInfoDo::getActivityId, activityId);
        }
        // 手机号批量查询
        if (phoneList != null && phoneList.size() > 0) {
            queryWrapper.in(ActivityInfoDo::getPhone, phoneList);
        }
        return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    public List<ActivityInfoDo> selectActivityInfoListByActivityIdAndSinglePhone(Long activityId, String phone) {
        return null;
    }

    @Override
    public List<ActivityInfoDo> selectActivityInfoListByActivityIdAndSinglePhoneAndBpin(Long activityId, String phone, String bpin) {
        return null;
    }

//    @Override
//    public List<ActivityInfoDo> selectActivityInfoListByActivityIdAndSinglePhone(Long activityId, String phone) {
//        LambdaQueryWrapper<ActivityInfoDo> queryWrapper = new LambdaQueryWrapper<>();
//        // 活动id
//        if (activityId != null
//                && activityId != 0) {
//            queryWrapper.eq(ActivityInfoDo::getActivityId, activityId);
//        }
//        // 手机号单笔查询
//        if (StringUtils.isNotBlank(phone)) {
//            queryWrapper.eq(ActivityInfoDo::getPhone, phone);
//        }
//        return this.baseMapper.selectList(queryWrapper);
//    }

//    @Override
//    public List<ActivityInfoDo> selectActivityInfoListByActivityIdAndSinglePhoneAndBpin(Long activityId, String phone, String bpin) {
//        LambdaQueryWrapper<ActivityInfoDo> queryWrapper = new LambdaQueryWrapper<>();
//        // 活动id
//        if (activityId != null
//                && activityId != 0) {
//            queryWrapper.eq(ActivityInfoDo::getActivityId, activityId);
//        }
//        // 手机号单笔查询
//        if (StringUtils.isNotBlank(phone)) {
//            queryWrapper.eq(ActivityInfoDo::getPhone, phone);
//        }
//        if (StringUtils.isNotBlank(bpin)) {
//            queryWrapper.eq(ActivityInfoDo::getBpin, bpin);
//        }
//        return this.baseMapper.selectList(queryWrapper);
//    }

    @Override
    public List<String> selectPhoneByActivityId(Long activityId) {
        return this.baseMapper.selectPhoneByActivityId(activityId);
    }

}
