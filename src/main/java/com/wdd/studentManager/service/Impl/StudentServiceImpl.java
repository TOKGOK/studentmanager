package com.wdd.studentManager.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wdd.studentManager.dto.StudentDto;
import com.wdd.studentManager.entity.StudentPo;
import com.wdd.studentManager.mapper.StudenetMapper;
import com.wdd.studentManager.service.StudentService;
import com.wdd.studentManager.util.PageBean;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Classname StudentServiceImpl
 * @Description None
 * @Date 2019/6/27 14:12
 * @Created by WDD
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudenetMapper, StudentPo> implements StudentService {

    @Resource
    private StudenetMapper studenetMapper;

    @Override
    public PageBean<StudentDto> queryPage(Map<String, Object> paramMap) {
        PageBean<StudentDto> pageBean = new PageBean<>((Integer) paramMap.get("pageno"),(Integer) paramMap.get("pagesize"));

        Integer startIndex = pageBean.getStartIndex();
        paramMap.put("startIndex",startIndex);
        List<StudentDto> datas = studenetMapper.queryList(paramMap);
        pageBean.setDatas(datas);

        Integer totalsize = studenetMapper.queryCount(paramMap);
        pageBean.setTotalsize(totalsize);
        return pageBean;
    }

    @Override
    public int deleteStudent(List<String> ids) {
        AtomicInteger count = new AtomicInteger();
        ids.forEach(id -> {
            removeById(id);
            count.getAndIncrement();
        });
        return count.get();
    }

    @Override
    public int addStudent(StudentDto studentDto) {
        StudentPo studentPo = new StudentPo();
        BeanUtils.copyProperties(studentDto,studentPo);
        return save(studentPo) ? 1 : 0;
    }

    @Override
    public StudentDto findById(String sid) {
        LambdaQueryWrapper<StudentPo> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(StudentPo::getId,sid);
        StudentPo studentPo = studenetMapper.selectOne(wrapper);
        StudentDto studentDto = new StudentDto();
        BeanUtils.copyProperties(studentDto,studentPo);
        return studentDto;
    }

    @Override
    public int editStudent(StudentDto studentDto) {
        StudentPo studentPo = new StudentPo();
        BeanUtils.copyProperties(studentDto,studentPo);
        return saveOrUpdate(studentPo) ? 1 : 0;
    }

    @Override
    public StudentDto findByStudent(StudentDto studentDto) {
        LambdaQueryWrapper<StudentPo> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(StudentPo::getUsername,studentDto.getUsername())
                .eq(StudentPo::getPassword,studentDto.getPassword());
        StudentPo studentPo = studenetMapper.selectOne(wrapper);
        BeanUtils.copyProperties(studentDto,studentPo);
        return studentDto;
    }

    @Override
    public boolean isStudentByClazzId(String id) {
        LambdaQueryWrapper<StudentPo> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(StudentPo::getClazzId,id);
        StudentPo studentPo = studenetMapper.selectOne(wrapper);
        return studentPo != null;
    }

    @Override
    public int editPasswordByStudent(StudentDto studentDto) {
        StudentPo studentPo = new StudentPo();
        BeanUtils.copyProperties(studentDto,studentPo);
        return saveOrUpdate(studentPo) ? 1 : 0;
    }

    @Override
    public String findByName(String name) {
        LambdaQueryWrapper<StudentPo> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(StudentPo::getUsername,name);
        return studenetMapper.selectOne(wrapper).getId();
    }
}
