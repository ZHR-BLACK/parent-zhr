package com.zhr.db.junit;

import com.zhr.db.dao.StudentDao;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
}
