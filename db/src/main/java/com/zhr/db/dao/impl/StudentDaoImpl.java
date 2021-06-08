package com.zhr.db.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhr.db.dao.StudentDao;
import com.zhr.db.dao.mapper.StudentMapper;
import com.zhr.db.dao.table.StudentDo;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @创建人 zhangjing710
 * @创建时间 2021/2/9 15:27
 * @描述
 */

@Component
public class StudentDaoImpl extends ServiceImpl<StudentMapper, StudentDo> implements StudentDao {

    @Override
    public List<Long> selectAllId() {
        return this.baseMapper.selectAllId();
    }

    @Override
    public List<StudentDo> selectPhoneForPage(int startPage, int pageSize) {
        QueryWrapper<StudentDo> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("age");
        queryWrapper.groupBy("age");
        queryWrapper.having("count(1) > 1");
//        queryWrapper.last("limit " + startPage + "," + pageSize);
        return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    public boolean batchInsertOrUpdate(List<StudentDo> studentDoList) {
        return this.saveOrUpdateBatch(studentDoList, studentDoList.size());
    }
}
