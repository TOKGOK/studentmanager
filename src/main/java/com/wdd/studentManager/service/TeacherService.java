package com.wdd.studentManager.service;

import com.wdd.studentManager.domain.Teacher;
import com.wdd.studentManager.util.PageBean;

import java.util.List;
import java.util.Map;

/**
 * @Classname TeacherService
 * @Description None
 * @Date 2019/6/28 18:56
 * @Created by WDD
 */
public interface TeacherService {
    PageBean<Teacher> queryPage(Map<String, Object> paramMap);

    int deleteTeacher(List<Integer> ids);

    int addTeacher(Teacher teacher);

    Teacher findById(Integer tid);

    int editTeacher(Teacher teacher);

    Teacher findByTeacher(Teacher teacher);

    int editPswdByTeacher(Teacher teacher);
}
