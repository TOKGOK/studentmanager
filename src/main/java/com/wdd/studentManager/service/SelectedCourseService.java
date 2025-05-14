package com.wdd.studentManager.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wdd.studentManager.dto.SelectedCourseDto;
import com.wdd.studentManager.entity.SelectedCoursePo;
import com.wdd.studentManager.util.PageBean;

import java.util.List;
import java.util.Map;

/**
 * @Classname SelectedCourseService
 * @Description None
 * @Date 2019/6/30 10:48
 * @Created by WDD
 */
public interface SelectedCourseService extends IService<SelectedCoursePo> {
    PageBean<SelectedCourseDto> queryPage(Map<String, Object> paramMap);

    int addSelectedCourse(SelectedCourseDto selectedCourseDto);

    int deleteSelectedCourse(Integer id);

    boolean isStudentId(String id);

    List<SelectedCourseDto> getAllBySid(int studentId);
}
