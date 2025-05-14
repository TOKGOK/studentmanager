package com.wdd.studentManager.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wdd.studentManager.dto.TeacherDto;
import com.wdd.studentManager.entity.TeacherPo;
import com.wdd.studentManager.util.PageBean;

import java.util.List;
import java.util.Map;

/**
 * @Classname TeacherService
 * @Description None
 * @Date 2019/6/28 18:56
 * @Created by WDD
 */
public interface TeacherService extends IService<TeacherPo> {
    PageBean<TeacherDto> queryPage(Map<String, Object> paramMap);

    int deleteTeacher(List<String> ids);

    int addTeacher(TeacherDto teacherDto);

    TeacherDto findById(String tid);

    int editTeacher(TeacherDto teacherDto);

    TeacherDto findByTeacher(TeacherDto teacherDto);

    int editPswdByTeacher(TeacherDto teacherDto);
}
