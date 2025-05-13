package com.wdd.studentManager.service;

import com.wdd.studentManager.domain.Student;
import com.wdd.studentManager.util.PageBean;

import java.util.List;
import java.util.Map;

/**
 * @Classname StudentService
 * @Description None
 * @Date 2019/6/27 14:11
 * @Created by WDD
 */
public interface StudentService {
    PageBean<Student> queryPage(Map<String, Object> paramMap);

    int deleteStudent(List<String> ids);

    int addStudent(Student student);

    Student findById(String sid);

    int editStudent(Student student);

    Student findByStudent(Student student);

    boolean isStudentByClazzId(String next);

    int editPswdByStudent(Student student);

    int findByName(String username);
}
