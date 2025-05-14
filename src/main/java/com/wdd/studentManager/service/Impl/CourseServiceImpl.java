package com.wdd.studentManager.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wdd.studentManager.entity.CoursePo;
import com.wdd.studentManager.mapper.CourseMapper;
import com.wdd.studentManager.service.CourseService;
import com.wdd.studentManager.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Classname CourseServiceImpl
 * @Description None
 * @Date 2019/6/29 20:09
 * @Created by WDD
 */
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper,CoursePo> implements CourseService {

    @Autowired
    private CourseMapper courseMapper;

    @Override
    public PageBean<CoursePo> queryPage(Map<String, Object> paramMap) {
        PageBean<CoursePo> pageBean = new PageBean<>((Integer) paramMap.get("pageno"),(Integer) paramMap.get("pagesize"));

        Integer startIndex = pageBean.getStartIndex();
        paramMap.put("startIndex",startIndex);
        List<CoursePo> datas = courseMapper.queryList(paramMap);
        pageBean.setDatas(datas);

        Integer totalsize = courseMapper.queryCount(paramMap);
        pageBean.setTotalsize(totalsize);
        return pageBean;
    }

    @Override
    public int addCourse(CoursePo coursePo) {
        return courseMapper.addCourse(coursePo);
    }

    @Override
    public int editCourse(CoursePo coursePo) {
        return courseMapper.editCourse(coursePo);
    }

    @Override
    public int deleteCourse(List<String> ids) {
        return courseMapper.deleteCourse(ids);
    }

    @Override
    public List<CoursePo> getCourseById(List<String> ids) {
        return courseMapper.getCourseById(ids);
    }

    @Override
    public int findByName(String name) {
        return courseMapper.findByName(name);
    }

}
