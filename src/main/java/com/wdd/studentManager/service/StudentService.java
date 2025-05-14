package com.wdd.studentManager.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wdd.studentManager.dto.StudentDto;
import com.wdd.studentManager.entity.StudentPo;
import com.wdd.studentManager.util.PageBean;

import java.util.List;
import java.util.Map;

/**
 * @Classname StudentService
 * @Description None
 * @Date 2019/6/27 14:11
 * @Created by WDD
 */
public interface StudentService extends IService<StudentPo> {
    PageBean<StudentDto> queryPage(Map<String, Object> paramMap);

    int deleteStudent(List<String> ids);

    int addStudent(StudentDto studentDto);

    StudentDto findById(String sid);

    int editStudent(StudentDto studentDto);

    StudentDto findByStudent(StudentDto studentDto);

    boolean isStudentByClazzId(String next);

    int editPswdByStudent(StudentDto studentDto);

    int findByName(String username);
}
