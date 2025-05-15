package com.wdd.studentManager.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wdd.studentManager.dto.CourseDto;
import com.wdd.studentManager.entity.CoursePo;
import com.wdd.studentManager.mapper.CourseMapper;
import com.wdd.studentManager.service.CourseService;
import com.wdd.studentManager.util.PageBean;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Classname CourseServiceImpl
 * @Description None
 * @Date 2019/6/29 20:09
 * @Created by WDD
 */
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper,CoursePo> implements CourseService {

    @Resource
    private CourseMapper courseMapper;

    @Override
    public PageBean<CourseDto> queryPage(Map<String, Object> paramMap) {
        PageBean<CourseDto> pageBean = new PageBean<>((Integer) paramMap.get("pageno"),(Integer) paramMap.get("pagesize"));

        Integer startIndex = pageBean.getStartIndex();
        paramMap.put("startIndex",startIndex);
        List<CourseDto> data = courseMapper.queryList(paramMap);
        pageBean.setDatas(data);

        Integer totalSize = courseMapper.queryCount(paramMap);
        pageBean.setTotalsize(totalSize);
        return pageBean;
    }

    @Override
    public int addCourse(CourseDto course) {
        CoursePo coursePo = new CoursePo();
        BeanUtils.copyProperties(course,coursePo);
        return save(coursePo) ? 1 : 0;
    }

    @Override
    public int editCourse(CourseDto course) {
        CoursePo coursePo = new CoursePo();
        BeanUtils.copyProperties(course,coursePo);
        return saveOrUpdate(coursePo) ? 1 : 0;
    }

    @Override
    public int deleteCourse(List<String> ids) {
        AtomicInteger count = new AtomicInteger();
        ids.forEach(id->{
            if(removeById(id)){
                count.getAndIncrement();
            }
        });
        return count.get();
    }

    @Override
    public List<CourseDto> getCourseById(List<String> ids) {
        LambdaQueryWrapper<CoursePo> wrapper = Wrappers.lambdaQuery();
        wrapper.in(CoursePo::getId,ids);
        List<CoursePo> coursePos = courseMapper.selectList(wrapper);
        List<CourseDto> courseDtoList = new ArrayList<>();
        BeanUtils.copyProperties(coursePos,courseDtoList);
        return courseDtoList;
    }

    @Override
    public String findCourseIdByName(String name) {
        return courseMapper.findByName(name);
    }

}
