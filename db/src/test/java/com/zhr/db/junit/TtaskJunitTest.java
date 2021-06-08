package com.zhr.db.junit;

import com.zhr.db.dao.TtaskDao;
import com.zhr.db.dao.table.TtaskDo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @创建人 zhangjing710
 * @创建时间 2021/3/4 9:59
 * @描述
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@PropertySource({"classpath:application.properties"})
@Slf4j
public class TtaskJunitTest {

    @Autowired
    public TtaskDao ttaskDao;

    @Test
    public void testSelectAllId() {
        TtaskDo ttaskDo = new TtaskDo();
        ttaskDo.setHasDeal(2);
        ttaskDo.setMethodName("sadasd");
        ttaskDo.setParam("sadasdasdasd");
        ttaskDo.setTaskMark(1);
        ttaskDo.setCreateDate(LocalDateTime.now());
        Long aLong = ttaskDao.saveTtask(ttaskDo);
        log.info("aLong = " + aLong);
    }
    @Test
    public void testSelectByTaskMark(){
        List<TtaskDo> ttaskDos = ttaskDao.selectByTaskMark(1);
        System.out.println("ttaskDos = " + ttaskDos);

        ttaskDos.forEach(item -> {
            item.setId(null);
            item.setTaskMark(2);
        });
        ttaskDao.batchSaveOrUpdate(ttaskDos);
    }

    @Test
    public void testselectLastByMethodName(){
        List<String> methodNames = new ArrayList<>();
        methodNames.add("sadasd");
        methodNames.add("sadasd2");
        List<TtaskDo> ttaskDos = ttaskDao.selectLastByMethodName(methodNames);
        System.out.println("ttaskDos = " + ttaskDos);
    }

}
