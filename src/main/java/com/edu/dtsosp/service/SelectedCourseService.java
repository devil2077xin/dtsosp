package com.edu.dtsosp.service;

import com.edu.dtsosp.domain.SelectedCourse;
import com.edu.dtsosp.util.PageBean;

import java.util.List;
import java.util.Map;


public interface SelectedCourseService {
    PageBean<SelectedCourse> queryPage(Map<String, Object> paramMap);

    int addSelectedCourse(SelectedCourse selectedCourse);

    int deleteSelectedCourse(Integer id);

    boolean isStudentId(int id);

    List<SelectedCourse> getAllBySid(int studentid);
}
