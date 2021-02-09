package com.zhr.selfstudy.dao.test;

import com.zhr.selfstudy.config.SpringUtil;
import com.zhr.selfstudy.dao.StudentDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @创建人 zhangjing710
 * @创建时间 2021/2/9 15:29
 * @描述
 */
@SpringBootApplication
@PropertySource({"classpath:application.yml"})
@Slf4j
public class StudentTest {

    public static void main(String[] args) {
        SpringApplication.run(StudentTest.class, args);

        //调用Sercice层
        ApplicationContext context = SpringUtil.getApplicationContext();
        StudentDao studentDao = context.getBean(StudentDao.class);
        List<Long> longs = studentDao.selectAllId();
        System.out.println("longs = " + longs);

    }
}
