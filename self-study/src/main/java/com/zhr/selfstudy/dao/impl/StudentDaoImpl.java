package com.zhr.selfstudy.dao.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhr.selfstudy.dao.StudentDao;
import com.zhr.selfstudy.dao.mapper.StudentMapper;
import com.zhr.selfstudy.dao.table.StudentDo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @创建人 zhangjing710
 * @创建时间 2021/2/9 15:27
 * @描述
 */
@Slf4j
@Component
public class StudentDaoImpl extends ServiceImpl<StudentMapper, StudentDo> implements StudentDao {

    @Override
    public List<Long> selectAllId() {
        return this.baseMapper.selectAllId();
    }
}
