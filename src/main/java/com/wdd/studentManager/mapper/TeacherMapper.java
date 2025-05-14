package com.wdd.studentManager.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wdd.studentManager.dto.TeacherDto;
import com.wdd.studentManager.entity.TeacherPo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @Classname TeacherMapper
 * @Description None
 * @Date 2019/6/28 19:06
 * @Created by WDD
 */
@Mapper
public interface TeacherMapper extends BaseMapper<TeacherPo> {
    List<TeacherDto> queryList(Map<String, Object> paramMap);

    Integer queryCount(Map<String, Object> paramMap);

    int deleteTeacher(List<String> ids);

    int addTeacher(TeacherDto teacherDto);

    TeacherDto findById(String tid);

    int editTeacher(TeacherDto teacherDto);

    TeacherDto findByTeacher(TeacherDto teacherDto);

    int editPswdByTeacher(TeacherDto teacherDto);
}
