package com.zhr.db.junit;

import com.zhr.db.dao.StudentDao;
import com.zhr.db.dao.table.StudentDo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @创建人 zhangjing710
 * @创建时间 2021/2/9 15:46
 * @描述
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@PropertySource({"classpath:application.properties"})
@Slf4j
public class StudentDatabseTest {

    @Autowired
    public StudentDao studentDao;

    @Test
    public void testSelectAllId() {
        List<Long> longs = studentDao.selectAllId();
        log.info("longs = " + longs);
    }

    @Test
    public void testBatchInsert() {
        StudentDo studentDo = new StudentDo();
        studentDo.setId(2L);
        studentDo.setAge(21);

        StudentDo studentDo2 = new StudentDo();
        studentDo2.setName("李小三");
        studentDo2.setAge(23);

        List<StudentDo> studentDoList = new ArrayList<>();
        studentDoList.add(studentDo);
        studentDoList.add(studentDo2);

        boolean b = studentDao.batchInsertOrUpdate(studentDoList);
        log.info("b = " + b);
    }

    @Test
    public void testSelectPhoneForPage() {
        List<StudentDo> studentDos = studentDao.selectPhoneForPage(0, 2);
        log.info("studentDos = " + studentDos);
    }


}
