package com.wdd.studentManager.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wdd.studentManager.dto.AttendanceDto;
import com.wdd.studentManager.entity.AttendancePo;
import com.wdd.studentManager.util.PageBean;

import java.util.Map;

/**
 * @Classname AttendanceService
 * @Description None
 * @Date 2019/7/1 15:47
 * @Created by WDD
 */
public interface AttendanceService extends IService<AttendancePo> {
    PageBean<AttendanceDto> queryPage(Map<String, Object> paramMap);

    boolean isAttendance(AttendanceDto attendance);

    int addAttendance(AttendanceDto attendance);

    int deleteAttendance(String id);
}
