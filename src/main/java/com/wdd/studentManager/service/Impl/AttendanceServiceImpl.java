package com.wdd.studentManager.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wdd.studentManager.dto.AttendanceDto;
import com.wdd.studentManager.entity.AttendancePo;
import com.wdd.studentManager.mapper.AttendanceMapper;
import com.wdd.studentManager.service.AttendanceService;
import com.wdd.studentManager.util.PageBean;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Classname AttendanceServiceImpl
 * @Description None
 * @Date 2019/7/1 15:47
 * @Created by WDD
 */
@Service
public class AttendanceServiceImpl extends ServiceImpl<AttendanceMapper, AttendancePo> implements AttendanceService {

    @Resource
    private AttendanceMapper attendanceMapper;

    @Override
    public PageBean<AttendanceDto> queryPage(Map<String, Object> paramMap) {
        PageBean<AttendanceDto> pageBean = new PageBean<>((Integer) paramMap.get("pageno"),(Integer) paramMap.get("pagesize"));

        Integer startIndex = pageBean.getStartIndex();
        paramMap.put("startIndex",startIndex);
        List<AttendanceDto> data = attendanceMapper.queryList(paramMap);
        pageBean.setDatas(data);

        Integer totalSize = attendanceMapper.queryCount(paramMap);
        pageBean.setTotalsize(totalSize);
        return pageBean;
    }

    @Override
    public boolean isAttendance(AttendanceDto attendance) {
        LambdaQueryWrapper<AttendancePo> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(AttendancePo::getStudentId,attendance.getStudentId());
        wrapper.eq(AttendancePo::getCourseId,attendance.getCourseId());
        wrapper.eq(AttendancePo::getDate,attendance.getDate());
        wrapper.eq(AttendancePo::getType,attendance.getType());
        AttendancePo attendancePo = attendanceMapper.selectOne(wrapper);
        return attendancePo != null;
    }

    @Override
    public int addAttendance(AttendanceDto attendance) {
        AttendancePo attendancePo = new AttendancePo();
        BeanUtils.copyProperties(attendance,attendancePo);
        return saveOrUpdate(attendancePo) ? 1 : 0;
    }

    @Override
    public int deleteAttendance(String id) {
        return attendanceMapper.deleteAttendance(id);
    }
}
