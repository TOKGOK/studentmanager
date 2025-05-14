package com.wdd.studentManager.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wdd.studentManager.dto.TeacherDto;
import com.wdd.studentManager.entity.TeacherPo;
import com.wdd.studentManager.mapper.TeacherMapper;
import com.wdd.studentManager.service.TeacherService;
import com.wdd.studentManager.util.PageBean;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Classname TeacherServiceImpl
 * @Description None
 * @Date 2019/6/28 18:56
 * @Created by WDD
 */
@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, TeacherPo> implements TeacherService {

    @Resource
    private TeacherMapper teacherMapper;

    @Override
    public PageBean<TeacherDto> queryPage(Map<String, Object> paramMap) {
        PageBean<TeacherDto> pageBean = new PageBean<>((Integer) paramMap.get("pageno"),(Integer) paramMap.get("pagesize"));

        Integer startIndex = pageBean.getStartIndex();
        paramMap.put("startIndex",startIndex);
        List<TeacherDto> datas = teacherMapper.queryList(paramMap);
        pageBean.setDatas(datas);

        Integer totalsize = teacherMapper.queryCount(paramMap);
        pageBean.setTotalsize(totalsize);
        return pageBean;
    }

    @Override
    public int deleteTeacher(List<String> ids) {
        return teacherMapper.deleteTeacher(ids);
    }

    @Override
    public int addTeacher(TeacherDto teacherDto) {
        return teacherMapper.addTeacher(teacherDto);
    }

    @Override
    public TeacherDto findById(String tid) {
        return teacherMapper.findById(tid);
    }

    @Override
    public int editTeacher(TeacherDto teacherDto) {
        return teacherMapper.editTeacher(teacherDto);
    }

    @Override
    public TeacherDto findByTeacher(TeacherDto teacherDto) {
        return teacherMapper.findByTeacher(teacherDto);
    }

    @Override
    public int editPswdByTeacher(TeacherDto teacherDto) {
        return teacherMapper.editPswdByTeacher(teacherDto);
    }
}
