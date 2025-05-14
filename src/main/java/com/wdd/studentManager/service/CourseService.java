package com.wdd.studentManager.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wdd.studentManager.entity.CoursePo;
import com.wdd.studentManager.util.PageBean;

import java.util.List;
import java.util.Map;

/**
 * @Classname CourseService
 * @Description None
 * @Date 2019/6/29 20:09
 * @Created by WDD
 */
public interface CourseService extends IService<CoursePo> {
    PageBean<CoursePo> queryPage(Map<String, Object> paramMap);

    int addCourse(CoursePo coursePo);

    int editCourse(CoursePo coursePo);

    int deleteCourse(List<String> ids);

    List<CoursePo> getCourseById(List<String> ids);

    int findByName(String name);
}
