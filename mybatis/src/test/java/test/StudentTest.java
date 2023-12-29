package test;

import com.alibaba.fastjson.JSON;
import com.zhr.dao.StudentDao;
import com.zhr.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class StudentTest {

    /**
     * 数据为空时返回null
     */
    @Test
    public void selStudentTest() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao mapper = sqlSession.getMapper(StudentDao.class);
        List<Map<String, Object>> maps = mapper.selStudent();
        System.out.println(JSON.toJSONString(maps));

        sqlSession.close();
    }
    /**
     * 数据为空时返回null
     */
    @Test
    public void selStudentMapTest() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao mapper = sqlSession.getMapper(StudentDao.class);
        List<Map<String, Object>> maps = mapper.selStudentMap();
        System.out.println(JSON.toJSONString(maps));

        sqlSession.close();
    }

    /**
     * 连表查询两个表字段数据
     */
    @Test
    public void selStudentClassMapListTest() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao mapper = sqlSession.getMapper(StudentDao.class);
        List<Map<String, Object>> maps = mapper.selStudentClassMapList();
        System.out.println(JSON.toJSONString(maps));

        sqlSession.close();
    }
    /**
     * 返回单个字段list集合
     */
    @Test
    public void selStudentIdListTest() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao mapper = sqlSession.getMapper(StudentDao.class);
        List<Long> ids = mapper.selStudentIdList();
        System.out.println(JSON.toJSONString(ids));

        sqlSession.close();
    }
}
