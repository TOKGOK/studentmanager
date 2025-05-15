package com.wdd.studentManager.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wdd.studentManager.dto.CourseDto;
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
    PageBean<CourseDto> queryPage(Map<String, Object> paramMap);

    int addCourse(CourseDto coursePo);

    int editCourse(CourseDto coursePo);

    int deleteCourse(List<String> ids);

    List<CourseDto> getCourseById(List<String> ids);

    String findCourseIdByName(String name);
}
