package com.wdd.studentManager.service;

import com.wdd.studentManager.domain.Leave;
import com.wdd.studentManager.util.PageBean;

import java.util.Map;

/**
 * @Classname LeaveService
 * @Description None
 * @Date 2019/7/2 15:54
 * @Created by WDD
 */
public interface LeaveService {
    PageBean<Leave> queryPage(Map<String, Object> paramMap);

    int addLeave(Leave leave);

    int editLeave(Leave leave);

    int checkLeave(Leave leave);

    int deleteLeave(Integer id);
}
