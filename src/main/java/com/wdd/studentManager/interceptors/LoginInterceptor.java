package com.wdd.studentManager.interceptors;

import com.wdd.studentManager.dto.StudentDto;
import com.wdd.studentManager.dto.TeacherDto;
import com.wdd.studentManager.dto.AdminDto;
import com.wdd.studentManager.util.Const;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Classname LoginInterceptor
 * @Description 登录拦截器
 * @Date 2019/6/25 16:09
 * @Created by WDD
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        AdminDto user = (AdminDto)request.getSession().getAttribute(Const.ADMIN);
        TeacherDto teacherDto = (TeacherDto)request.getSession().getAttribute(Const.TEACHER);
        StudentDto studentDto = (StudentDto)request.getSession().getAttribute(Const.STUDENT);
        if(!StringUtils.isEmpty(user) || !StringUtils.isEmpty(teacherDto) || !StringUtils.isEmpty(studentDto)){
            return true;
        }
        response.sendRedirect(request.getContextPath() + "/system/login");
        return false;
    }

}
