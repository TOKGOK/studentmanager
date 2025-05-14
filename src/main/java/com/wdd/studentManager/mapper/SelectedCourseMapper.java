package com.wdd.studentManager.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wdd.studentManager.dto.SelectedCourseDto;
import com.wdd.studentManager.entity.SelectedCoursePo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @Classname SelectedCourseMapper
 * @Description None
 * @Date 2019/6/30 10:56
 * @Created by WDD
 */
@Mapper
public interface SelectedCourseMapper extends BaseMapper<SelectedCoursePo> {
    List<SelectedCourseDto> queryList(Map<String, Object> paramMap);

    Integer queryCount(Map<String, Object> paramMap);

    int addSelectedCourse(SelectedCourseDto selectedCourseDto);

    SelectedCourseDto findBySelectedCourse(SelectedCourseDto selectedCourseDto);

    SelectedCourseDto findById(Integer id);

    int deleteSelectedCourse(Integer id);

    List<SelectedCourseDto> isStudentId(String id);

    List<SelectedCourseDto> getAllBySid(int studentId);
}
