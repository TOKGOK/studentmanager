package com.wdd.studentManager.mapper;

import com.wdd.studentManager.domain.Teacher;
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
public interface TeacherMapper {
    List<Teacher> queryList(Map<String, Object> paramMap);

    Integer queryCount(Map<String, Object> paramMap);

    int deleteTeacher(List<String> ids);

    int addTeacher(Teacher teacher);

    Teacher findById(String tid);

    int editTeacher(Teacher teacher);

    Teacher findByTeacher(Teacher teacher);

    int editPswdByTeacher(Teacher teacher);
}
