package com.zhr.db.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhr.db.bean.VendersQuery;
import com.zhr.db.dao.TtaskDao;
import com.zhr.db.dao.mapper.TtaskMapper;
import com.zhr.db.dao.table.TtaskDo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @创建人 zhangjing710
 * @创建时间 2021/3/3 10:48
 * @描述
 */
@Slf4j
@Component
public class TtaskDaoImpl extends ServiceImpl<TtaskMapper, TtaskDo> implements TtaskDao {

    @Override
    public Long saveTtask(TtaskDo ttaskDo) {
        ttaskDo.setCreateDate(LocalDateTime.now());
        ttaskDo.setUpdateTime(LocalDateTime.now());
        this.baseMapper.saveTtask(ttaskDo);
        return ttaskDo.getId();
    }

    @Override
    public boolean batchSaveOrUpdate(List<TtaskDo> ttaskDoList) {
        return this.saveOrUpdateBatch(ttaskDoList, ttaskDoList.size());
    }
    @Override
    public List<TtaskDo> selectByTaskMark(int taskMark) {
        LambdaQueryWrapper<TtaskDo> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(TtaskDo::getTaskMark,taskMark);

        return this.baseMapper.selectList(wrapper);
    }

    @Override
    public List<TtaskDo> selectLastByMethodName(List<String> methodNameList) {
//        String sql = "SELECT\n" +
//                "\ta.*\n" +
//                "FROM\n" +
//                "\tt_task AS a\n" +
//                "RIGHT JOIN (\n" +
//                "\tSELECT\n" +
//                "\t\tparam,\n" +
//                "\t\tmax(create_date) AS maxtime\n" +
//                "\tFROM\n" +
//                "\t\tt_task\n" +
//                "\tWHERE\n" +
//                "\t\tmethod_name in " + methodNameList +
//                "\n" +
//                "\tGROUP BY param\n" +
//                ") AS b ON a.param = b.param\n" +
//                "AND a.create_date = b.maxtime;";
//        QueryWrapper<TtaskDo> wrapper = new QueryWrapper<>();
//        wrapper.last(sql);
//        return this.baseMapper.selectList(wrapper);
//        Map<String, List<String>> map = new HashMap<>();
//        map.put("methodNameList", methodNameList);
        return this.baseMapper.selectLastByMethodName(methodNameList);


    }


}
