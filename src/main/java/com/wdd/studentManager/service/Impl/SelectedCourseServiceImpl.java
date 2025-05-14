package com.wdd.studentManager.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wdd.studentManager.dto.SelectedCourseDto;
import com.wdd.studentManager.entity.SelectedCoursePo;
import com.wdd.studentManager.mapper.CourseMapper;
import com.wdd.studentManager.mapper.SelectedCourseMapper;
import com.wdd.studentManager.service.SelectedCourseService;
import com.wdd.studentManager.util.PageBean;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * @Classname SelectedCourseServiceImpl
 * @Description None
 * @Date 2019/6/30 10:48
 * @Created by WDD
 */
@Service
public class SelectedCourseServiceImpl extends ServiceImpl<SelectedCourseMapper, SelectedCoursePo> implements SelectedCourseService {

    @Resource
    private SelectedCourseMapper selectedCourseMapper;
    @Resource
    private CourseMapper courseMapper;

    @Override
    public PageBean<SelectedCourseDto> queryPage(Map<String, Object> paramMap) {
        PageBean<SelectedCourseDto> pageBean = new PageBean<>((Integer) paramMap.get("pageno"),(Integer) paramMap.get("pagesize"));

        Integer startIndex = pageBean.getStartIndex();
        paramMap.put("startIndex",startIndex);
        List<SelectedCourseDto> datas = selectedCourseMapper.queryList(paramMap);
        pageBean.setDatas(datas);

        Integer totalsize = selectedCourseMapper.queryCount(paramMap);
        pageBean.setTotalsize(totalsize);
        return pageBean;
    }

    @Override
    @Transactional
    public int addSelectedCourse(SelectedCourseDto selectedCourseDto) {
        SelectedCourseDto s = selectedCourseMapper.findBySelectedCourse(selectedCourseDto);
        if(StringUtils.isEmpty(s)){
            int count = courseMapper.addStudentNum(selectedCourseDto.getCourseId());
            if(count == 1){
                selectedCourseMapper.addSelectedCourse(selectedCourseDto);
                return count;
            }
            if(count == 0){
                return count;
            }
        }else{
            return 2;
        }
        return 3;
    }

    @Override
    @Transactional
    public int deleteSelectedCourse(Integer id) {
        SelectedCourseDto selectedCourseDto = selectedCourseMapper.findById(id);
        courseMapper.deleteStudentNum(selectedCourseDto.getCourseId());
        return selectedCourseMapper.deleteSelectedCourse(id);
    }

    @Override
    public boolean isStudentId(String id) {
        List<SelectedCourseDto> selectedCourseDtoList = selectedCourseMapper.isStudentId(id);
        if (selectedCourseDtoList.isEmpty()){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public List<SelectedCourseDto> getAllBySid(int studentId) {
        return selectedCourseMapper.getAllBySid(studentId);
    }
}
