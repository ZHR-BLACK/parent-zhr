package com.zhr.db.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhr.db.dao.table.StudentDo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @创建人 zhangjing710
 * @创建时间 2021/2/9 15:10
 * @描述 StudentMapper
 */
@Mapper
public interface StudentMapper extends BaseMapper<StudentDo> {

    @Select("select id from t_student")
    List<Long> selectAllId();
}
