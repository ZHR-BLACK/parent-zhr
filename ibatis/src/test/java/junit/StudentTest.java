package junit;

import com.alibaba.fastjson.JSON;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.zhr.pojo.Student;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.*;

public class StudentTest {

    public static SqlMapClient sqlMapClient = null;

    static {
        try {
            Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
            sqlMapClient = SqlMapClientBuilder.buildSqlMapClient(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void findAll() {
        List<Student> list = null;
        try {
            list = sqlMapClient.queryForList("findAll");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("list = " + JSON.toJSONString(list));
    }

    @Test
    public void findAllAs() {
        List<Student> list = new ArrayList<>();
        try {
            list = sqlMapClient.queryForList("findAllAs");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("list = " + JSON.toJSONString(list));
        Date createTime = list.get(0).getCreateTime();
        System.out.println("createTime = " + createTime);
    }

    @Test
    public void findByID() {
        Student student = null;
        try {
            student = (Student) sqlMapClient.queryForObject("findByID", 2L);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("list = " + JSON.toJSONString(student));
    }

    @Test
    public void findByIds() {
        List<Student> students = null;
        List<Long> ids = new ArrayList<>();
        ids.add(1L);
        ids.add(2L);
        try {
            students = (List<Student>) sqlMapClient.queryForList("findAllIn", ids);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("list = " + JSON.toJSONString(students));
    }

    @Test
    public void findByTimeRangeTest() {
        List<Student> students = null;
        Student student = new Student();
        student.setCreateTime(new Date());
        try {
            students = (List<Student>) sqlMapClient.queryForList("findByTimeRange", student);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("list = " + JSON.toJSONString(students));
    }

    @Test
    public void addStudent() {
        Student student = new Student();
        student.setName("宋达");
        student.setAge(14);
        student.setAddress("上海");
        student.setCreateTime(new Date());
        try {
            Long insertStudentId = (Long) sqlMapClient.insert("insertStudent", student);
            System.out.println("insertStudentId = " + insertStudentId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void deleteStudentByID() {
        try {
            sqlMapClient.delete("deleteStudentByID", 2L);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void deleteStudent() {
        Student student = new Student();
        student.setId(2L);
        try {
            sqlMapClient.delete("deleteStudent", student);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void updateStudent() {
        Student student = new Student();
        try {
            sqlMapClient.update("updateStudent", student);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void findByCon() {
        List<Student> stuList = new ArrayList<>();
        try {
            stuList = sqlMapClient.queryForList("selectByLike", "啥");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("stuList = " + JSON.toJSONString(stuList));
    }

    @Test
    public void findByCon1() {
        Student student = new Student();
        student.setName("啥");
        student.setAge(10);
        List<Student> stuList = new ArrayList<>();
        try {
            stuList = sqlMapClient.queryForList("findByCon1", student);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("stuList = " + JSON.toJSONString(stuList));
    }

    @Test
    public void findByCon2() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "%啥%");
        map.put("age", 5);
        List<Student> stuList = new ArrayList<>();
        try {
            stuList = sqlMapClient.queryForList("findByCon2", map);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("stuList = " + JSON.toJSONString(stuList));
    }
}
