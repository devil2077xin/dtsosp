package com.edu.dtsosp.service;

import com.edu.dtsosp.domain.Clazz;
import com.edu.dtsosp.util.PageBean;

import java.util.List;
import java.util.Map;


public interface ClazzService {
    PageBean<Clazz> queryPage(Map<String, Object> paramMap);

    int addClazz(Clazz clazz);

    int deleteClazz(List<Integer> ids);

    int editClazz(Clazz clazz);

    Clazz findByName(String clazzName);

}
