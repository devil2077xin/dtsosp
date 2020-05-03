package com.edu.dtsosp.service;

import com.edu.dtsosp.domain.Attendance;
import com.edu.dtsosp.util.PageBean;

import java.util.Map;


public interface AttendanceService {
    PageBean<Attendance> queryPage(Map<String, Object> paramMap);

    boolean isAttendance(Attendance attendance);

    int addAtendance(Attendance attendance);

    int deleteAttendance(Integer id);
}
