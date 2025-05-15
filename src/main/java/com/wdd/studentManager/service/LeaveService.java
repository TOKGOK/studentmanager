package com.wdd.studentManager.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wdd.studentManager.dto.LeaveDto;
import com.wdd.studentManager.entity.LeavePo;
import com.wdd.studentManager.util.PageBean;

import java.util.Map;

/**
 * @Classname LeaveService
 * @Description None
 * @Date 2019/7/2 15:54
 * @Created by WDD
 */
public interface LeaveService extends IService<LeavePo> {
    PageBean<LeaveDto> queryPage(Map<String, Object> paramMap);

    int addLeave(LeaveDto leaveDto);

    int editLeave(LeaveDto leaveDto);

    int checkLeave(LeaveDto leaveDto);

    int deleteLeave(String id);
}
