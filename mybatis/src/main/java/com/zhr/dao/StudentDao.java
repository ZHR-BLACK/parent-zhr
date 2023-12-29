package com.zhr.dao;

import java.util.List;
import java.util.Map;

public interface StudentDao {


    List<Map<String, Object>> selStudent();
    List<Map<String, Object>> selStudentMap();

    List<Map<String, Object>> selStudentClassMapList();

    List<Long> selStudentIdList();

}
