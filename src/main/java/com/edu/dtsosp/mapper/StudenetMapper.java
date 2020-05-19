package com.edu.dtsosp.mapper;

import com.edu.dtsosp.domain.Student;

import java.util.List;
import java.util.Map;


public interface StudenetMapper {
    List<Student> queryList(Map<String, Object> paramMap);

    Integer queryCount(Map<String, Object> paramMap);

    int deleteStudent(List<Integer> ids);

    int addStudent(Student student);

    Student findById(Integer sid);

    int editStudent(Student student);

    Student findByStudent(Student student);

    List<Student> isStudentByClazzId(Integer id);

    List<Student> isStudentByTermId(Integer id);

    int findByName(String name);
}
