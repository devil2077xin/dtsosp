package com.edu.dtsosp.service;

import com.edu.dtsosp.domain.Admin;


public interface AdminService {

    Admin findByAdmin(Admin admin);


    int editPswdByAdmin(Admin admin);
}
