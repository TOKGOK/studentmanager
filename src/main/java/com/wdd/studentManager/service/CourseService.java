package com.wdd.studentManager.service;

import com.wdd.studentManager.domain.Course;
import com.wdd.studentManager.util.PageBean;

import java.util.List;
import java.util.Map;

/**
 * @Classname CourseService
 * @Description None
 * @Date 2019/6/29 20:09
 * @Created by WDD
 */
public interface CourseService {
    PageBean<Course> queryPage(Map<String, Object> paramMap);

    int addCourse(Course course);

    int editCourse(Course course);

    int deleteCourse(List<String> ids);

    List<Course> getCourseById(List<String> ids);

    int findByName(String name);
}
