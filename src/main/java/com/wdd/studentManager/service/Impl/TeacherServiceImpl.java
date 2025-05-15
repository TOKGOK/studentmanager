package com.wdd.studentManager.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wdd.studentManager.dto.TeacherDto;
import com.wdd.studentManager.entity.TeacherPo;
import com.wdd.studentManager.mapper.TeacherMapper;
import com.wdd.studentManager.service.TeacherService;
import com.wdd.studentManager.util.PageBean;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

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
        AtomicInteger count = new AtomicInteger();
        ids.forEach(id -> {
            removeById(id);
            count.getAndIncrement();
        });
        return count.get();
    }

    @Override
    public int addTeacher(TeacherDto teacherDto) {
        TeacherPo teacherPo = new TeacherPo();
        BeanUtils.copyProperties(teacherDto,teacherPo);
        return save(teacherPo) ? 1 : 0;
    }

    @Override
    public TeacherDto findById(String tid) {
        LambdaQueryWrapper<TeacherPo> queryWrapper = Wrappers.<TeacherPo>lambdaQuery();
        queryWrapper.eq(TeacherPo::getId,tid);
        TeacherPo teacherPo = teacherMapper.selectOne(queryWrapper);
        TeacherDto teacherDto = new TeacherDto();
        BeanUtils.copyProperties(teacherPo,teacherDto);
        return teacherDto;
    }

    @Override
    public int editTeacher(TeacherDto teacherDto) {
        TeacherPo teacherPo = new TeacherPo();
        BeanUtils.copyProperties(teacherDto,teacherPo);
        return saveOrUpdate(teacherPo) ? 1 : 0;
    }

    @Override
    public TeacherDto findByTeacher(TeacherDto teacherDto) {
        LambdaQueryWrapper<TeacherPo> wrapper = Wrappers.<TeacherPo>lambdaQuery();
        wrapper.eq(TeacherPo::getUsername,teacherDto.getUsername())
                .eq(TeacherPo::getPassword,teacherDto.getPassword());
        TeacherPo teacherPo = teacherMapper.selectOne(wrapper);
        TeacherDto teacherDto1 = new TeacherDto();
        BeanUtils.copyProperties(teacherPo,teacherDto1);
        return teacherDto1;
    }

    @Override
    public int editPasswordByTeacher(TeacherDto teacherDto) {
        LambdaQueryWrapper<TeacherPo> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(TeacherPo::getId,teacherDto.getId());
        TeacherPo teacherPo = teacherMapper.selectOne(wrapper);
        teacherPo.setPassword(teacherDto.getPassword());
        return saveOrUpdate(teacherPo) ? 1 : 0;
    }
}
