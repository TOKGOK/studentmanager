package com.wdd.studentManager.controller;

import com.wdd.studentManager.dto.ClazzDto;
import com.wdd.studentManager.service.ClazzService;
import com.wdd.studentManager.service.StudentService;
import com.wdd.studentManager.util.AjaxResult;
import com.wdd.studentManager.util.Data;
import com.wdd.studentManager.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @Classname ClazzController
 * @Description 班级管理
 * @Date 2019/6/26 9:08
 * @Created by WDD
 */
@Controller
@RequestMapping("/clazz")
public class ClazzController {

    @Autowired
    private ClazzService clazzService;
    @Autowired
    private StudentService studentService;

    /**
     * 跳转班级页面
     * @return
     */
    @GetMapping("/clazz_list")
    public String clazzList(){
        return "/clazz/clazzList";
    }

    /**
     * 异步加载班级列表
     * @param page
     * @param rows
     * @param clazzName
     * @return
     */
    @PostMapping("/getClazzList")
    @ResponseBody
    public Object getClazzList(@RequestParam(value = "page", defaultValue = "1")Integer page,
                               @RequestParam(value = "rows", defaultValue = "100")Integer rows, String clazzName, String from){
        Map<String,Object> paramMap = new HashMap();
        paramMap.put("pageno",page);
        paramMap.put("pagesize",rows);
        if(!StringUtils.isEmpty(clazzName))  paramMap.put("name",clazzName);
        PageBean<ClazzDto> pageBean = clazzService.queryPage(paramMap);
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
     * 添加班级
     * @param clazz
     * @return
     */
    @PostMapping("/addClazz")
    @ResponseBody
    public AjaxResult addClazz(ClazzDto clazz){
        AjaxResult ajaxResult = new AjaxResult();
        try {
            int count = clazzService.addClazz(clazz);
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
     * 删除班级
     * @param data
     * @return
     */
    @PostMapping("/deleteClazz")
    @ResponseBody
    public AjaxResult deleteClazz(Data data){
        AjaxResult ajaxResult = new AjaxResult();
        try {
            List<String> ids = data.getIds();
            Iterator<String> iterator = ids.iterator();
            while (iterator.hasNext()){  //判断是否存在课程关联学生
                if(!studentService.isStudentByClazzId(iterator.next())){
                    ajaxResult.setSuccess(false);
                    ajaxResult.setMessage("无法删除,班级下存在学生");
                    return ajaxResult;
                }
            }
            int count = clazzService.deleteClazz(data.getIds());
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

    /**
     * 班级修改
     * @param clazz
     * @return
     */
    @PostMapping("/editClazz")
    @ResponseBody
    public AjaxResult editClazz(ClazzDto clazz){
        AjaxResult ajaxResult = new AjaxResult();
        try {
            int count = clazzService.editClazz(clazz);
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
}
