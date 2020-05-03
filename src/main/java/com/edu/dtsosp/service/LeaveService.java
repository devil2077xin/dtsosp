package com.edu.dtsosp.service;

import com.edu.dtsosp.domain.Leave;
import com.edu.dtsosp.util.PageBean;

import java.util.Map;


public interface LeaveService {
    PageBean<Leave> queryPage(Map<String, Object> paramMap);

    int addLeave(Leave leave);

    int editLeave(Leave leave);

    int checkLeave(Leave leave);

    int deleteLeave(Integer id);
}
