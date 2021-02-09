package com.zhr.selfstudy;

import com.zhr.selfstudy.dao.StudentDao;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @创建人 zhangjing710
 * @创建时间 2021/2/9 15:46
 * @描述
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
//@PropertySource({"classpath:application*.properties","classpath:application*.yml","classpath:log4j2.yml"})
@ContextConfiguration({"classpath:application*.properties","classpath:application*.yml","classpath:log4j2.yml","classpath:logback.xml"})
@Slf4j
public class StudentDatabseTest {

    @Autowired
    public StudentDao studentDao;

    @Test
    public void testSelectAllId(){
        List<Long> longs = studentDao.selectAllId();
        System.out.println("longs = " + longs);
    }
}
