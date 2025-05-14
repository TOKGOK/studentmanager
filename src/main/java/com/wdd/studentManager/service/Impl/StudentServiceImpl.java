package com.wdd.studentManager.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wdd.studentManager.dto.StudentDto;
import com.wdd.studentManager.entity.StudentPo;
import com.wdd.studentManager.mapper.StudenetMapper;
import com.wdd.studentManager.service.StudentService;
import com.wdd.studentManager.util.PageBean;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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
        return studenetMapper.deleteStudent(ids);
    }

    @Override
    public int addStudent(StudentDto studentDto) {
        return studenetMapper.addStudent(studentDto);
    }

    @Override
    public StudentDto findById(String sid) {
        return studenetMapper.findById(sid);
    }

    @Override
    public int editStudent(StudentDto studentDto) {
        return studenetMapper.editStudent(studentDto);
    }

    @Override
    public StudentDto findByStudent(StudentDto studentDto) {
        return studenetMapper.findByStudent(studentDto);
    }

    @Override
    public boolean isStudentByClazzId(String id) {
        List<StudentDto> studentDtoList = studenetMapper.isStudentByClazzId(id);
        if (studentDtoList.isEmpty()){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public int editPswdByStudent(StudentDto studentDto) {
        return studenetMapper.editPswdByStudent(studentDto);
    }

    @Override
    public int findByName(String name) {
        return studenetMapper.findByName(name);
    }
}
