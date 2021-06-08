package com.zhr.db.dao.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.zhr.db.bean.VendersQuery;
import com.zhr.db.dao.table.TtaskDo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @创建人 zhangjing710
 * @创建时间 2021/3/3 10:38
 * @描述 待处理任务mapper
 */
public interface TtaskMapper extends BaseMapper<TtaskDo> {

    @Insert("INSERT INTO t_task " +
            "(" +
            "param" +
            ",method_name" +
            ",task_mark" +
            ",has_deal" +
            ",update_time" +
            ",create_date) " +
            "VALUES " +
            "(" +
            "#{param}" +
            ",#{methodName}" +
            ",#{taskMark}" +
            ",#{hasDeal}" +
            ",#{updateTime}" +
            ",#{createDate})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    Long saveTtask(TtaskDo ttaskDo);

    @Select("<script>SELECT * FROM t_task AS a RIGHT JOIN (SELECT param,max(create_date) AS maxtime FROM t_task WHERE method_name in "
            + "<foreach item='methodName' index='index' collection='methodNameList' open='(' separator=',' close=')'>"
            + "#{methodName}"
            + "</foreach>"
            + " GROUP BY param) AS b ON a.param = b.param AND a.create_date = b.maxtime</script>")
    List<TtaskDo> selectLastByMethodName(@Param("methodNameList") List<String> methodNameList);

}
