package com.edu.dtsosp.service;

import com.edu.dtsosp.domain.Student;
import com.edu.dtsosp.util.PageBean;

import java.util.List;
import java.util.Map;


public interface StudentService {
    PageBean<Student> queryPage(Map<String, Object> paramMap);

    int deleteStudent(List<Integer> ids);

    int addStudent(Student student);

    Student findById(Integer sid);

    int editStudent(Student student);

    Student findByStudent(Student student);

    boolean isStudentByClazzId(Integer next);

    boolean isStudentByTermId(Integer next);

    int findByName(String username);
}
