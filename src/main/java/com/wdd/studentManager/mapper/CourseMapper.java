package com.wdd.studentManager.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wdd.studentManager.entity.CoursePo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @Classname CourseMapper
 * @Description None
 * @Date 2019/6/29 20:34
 * @Created by WDD
 */
@Mapper
public interface CourseMapper extends BaseMapper<CoursePo> {
    List<CoursePo> queryList(Map<String, Object> paramMap);

    Integer queryCount(Map<String, Object> paramMap);

    int addCourse(CoursePo coursePo);

    int editCourse(CoursePo coursePo);

    int deleteCourse(List<String> ids);

    int addStudentNum(String courseId);

    void deleteStudentNum(String courseId);

    List<CoursePo> getCourseById(List<String> ids);

    int findByName(String name);
}
