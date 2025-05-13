package com.wdd.studentManager.service;

import com.wdd.studentManager.domain.Admin;

/**
 * @Classname AdminService
 * @Description None
 * @Date 2019/6/25 11:07
 * @Created by WDD
 */
public interface AdminService {

    Admin findByAdmin(Admin admin);


    int editPswdByAdmin(Admin admin);
}
