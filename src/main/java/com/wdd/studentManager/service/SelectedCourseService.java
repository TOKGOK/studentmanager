package com.wdd.studentManager.service;

import com.wdd.studentManager.domain.SelectedCourse;
import com.wdd.studentManager.util.PageBean;

import java.util.List;
import java.util.Map;

/**
 * @Classname SelectedCourseService
 * @Description None
 * @Date 2019/6/30 10:48
 * @Created by WDD
 */
public interface SelectedCourseService {
    PageBean<SelectedCourse> queryPage(Map<String, Object> paramMap);

    int addSelectedCourse(SelectedCourse selectedCourse);

    int deleteSelectedCourse(Integer id);

    boolean isStudentId(String id);

    List<SelectedCourse> getAllBySid(int studentId);
}
