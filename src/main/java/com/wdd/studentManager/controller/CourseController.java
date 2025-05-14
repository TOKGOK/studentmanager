package com.wdd.studentManager.controller;

import com.wdd.studentManager.dto.CourseDto;
import com.wdd.studentManager.entity.CoursePo;
import com.wdd.studentManager.service.CourseService;
import com.wdd.studentManager.util.AjaxResult;
import com.wdd.studentManager.util.Data;
import com.wdd.studentManager.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname CourseController
 * @Description None
 * @Date 2019/6/29 20:02
 * @Created by WDD
 */
@Controller
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/course_list")
    public String courseList(){
        return "course/courseList";
    }

    /**
     * 异步加载课程信息列表
     * @param page
     * @param rows
     * @param name
     * @param teacherid
     * @param from
     * @return
     */
    @PostMapping("/getCourseList")
    @ResponseBody
    public Object getClazzList(@RequestParam(value = "page", defaultValue = "1")Integer page,
                               @RequestParam(value = "rows", defaultValue = "100")Integer rows,
                               String name,
                               @RequestParam(value = "teacherid", defaultValue = "0")String teacherid ,String from){
        Map<String,Object> paramMap = new HashMap();
        paramMap.put("pageno",page);
        paramMap.put("pagesize",rows);
        if(!StringUtils.isEmpty(name))  paramMap.put("name",name);
        if(!teacherid.equals("0"))  paramMap.put("teacherId",teacherid);
        PageBean<CourseDto> pageBean = courseService.queryPage(paramMap);
        if(!StringUtils.isEmpty(from) && from.equals("combox")){
            return pageBean.getDatas();
        }else{
            Map<String,Object> result = new HashMap();
            result.put("total",pageBean.getTotalsize());
            result.put("rows",pageBean.getDatas());
            return result;
        }
    }

    /**
     * 添加课程信息
     * @param coursePo
     * @return
     */
    @PostMapping("/addCourse")
    @ResponseBody
    public AjaxResult addCourse(CourseDto coursePo){
        AjaxResult ajaxResult = new AjaxResult();
        try {
            int count = courseService.addCourse(coursePo);
            if(count > 0){
                ajaxResult.setSuccess(true);
                ajaxResult.setMessage("添加成功");
            }else{
                ajaxResult.setSuccess(false);
                ajaxResult.setMessage("添加失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            ajaxResult.setSuccess(false);
            ajaxResult.setMessage("添加失败");
        }
        return ajaxResult;
    }


    /**
     * 修改课程信息
     * @param coursePo
     * @return
     */
    @PostMapping("/editCourse")
    @ResponseBody
    public AjaxResult editCourse(CourseDto coursePo){
        AjaxResult ajaxResult = new AjaxResult();
        try {
            int count = courseService.editCourse(coursePo);
            if(count > 0){
                ajaxResult.setSuccess(true);
                ajaxResult.setMessage("修改成功");
            }else{
                ajaxResult.setSuccess(false);
                ajaxResult.setMessage("修改失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            ajaxResult.setSuccess(false);
            ajaxResult.setMessage("修改失败");
        }
        return ajaxResult;
    }


    @PostMapping("/deleteCourse")
    @ResponseBody
    public AjaxResult deleteCourse(Data data){
        AjaxResult ajaxResult = new AjaxResult();
        try {
            int count = courseService.deleteCourse(data.getIds());
            if(count > 0){
                ajaxResult.setSuccess(true);
                ajaxResult.setMessage("删除成功");
            }else{
                ajaxResult.setSuccess(false);
                ajaxResult.setMessage("删除失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            ajaxResult.setSuccess(false);
            ajaxResult.setMessage("删除失败,该班级存在老师或学生");
        }
        return ajaxResult;
    }
}
