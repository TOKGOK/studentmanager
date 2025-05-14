package com.wdd.studentManager.controller;

import com.wdd.studentManager.dto.SelectedCourseDto;
import com.wdd.studentManager.dto.StudentDto;
import com.wdd.studentManager.entity.CoursePo;
import com.wdd.studentManager.dto.AttendanceDto;
import com.wdd.studentManager.service.AttendanceService;
import com.wdd.studentManager.service.CourseService;
import com.wdd.studentManager.service.SelectedCourseService;
import com.wdd.studentManager.util.AjaxResult;
import com.wdd.studentManager.util.Const;
import com.wdd.studentManager.util.DateFormatUtil;
import com.wdd.studentManager.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpSession;
import java.util.*;

/**
 * @Classname AttendanceController
 * @Description None
 * @Date 2019/7/1 11:57
 * @Created by WDD
 */
@Controller
@RequestMapping("/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;
    @Autowired
    private SelectedCourseService selectedCourseService;
    @Autowired
    private CourseService courseService;

    @GetMapping("/attendance_list")
    public String attendanceList(){
        return "/attendance/attendanceList";
    }


    /**
     * 异步获取考勤列表数据
     * @param page
     * @param rows
     * @param studentId
     * @param courseId
     * @param type
     * @param date
     * @param from
     * @param session
     * @return
     */
    @RequestMapping("/getAttendanceList")
    @ResponseBody
    public Object getAttendanceList(@RequestParam(value = "page", defaultValue = "1")Integer page,
                                 @RequestParam(value = "rows", defaultValue = "100")Integer rows,
                                 @RequestParam(value = "studentId", defaultValue = "0")String studentId,
                                 @RequestParam(value = "courseId", defaultValue = "0")String courseId,
                                 String type,String date, String from, HttpSession session){
        Map<String,Object> paramMap = new HashMap<>();
        paramMap.put("pageno",page);
        paramMap.put("pagesize",rows);
        if(!studentId.equals("0"))  paramMap.put("studentid", studentId);
        if(!courseId.equals("0"))  paramMap.put("courseid", courseId);
        if(!StringUtils.isEmpty(type))  paramMap.put("type",type);
        if(!StringUtils.isEmpty(date))  paramMap.put("date",date);

        //判断是老师还是学生权限
        StudentDto studentDto = (StudentDto) session.getAttribute(Const.STUDENT);
        if(!StringUtils.isEmpty(studentDto)){
            //是学生权限，只能查询自己的信息
            paramMap.put("studentid", studentDto.getId());
        }
        PageBean<AttendanceDto> pageBean = attendanceService.queryPage(paramMap);
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
     * 通过 选课信息中的课程id 查询 学生所选择的课程
     * @param studentid
     * @return
     */
    @RequestMapping("/getStudentSelectedCourseList")
    @ResponseBody
    public Object getStudentSelectedCourseList(@RequestParam(value = "studentid", defaultValue = "0")String studentid){
        //通过学生id 查询 选课信息
        List<SelectedCourseDto> selectedCourseDtoList = selectedCourseService.getAllBySid(Integer.parseInt(studentid));
        //通过 选课信息中的课程id 查询 学生所选择的课程
        List<String> ids = new ArrayList<>();
        for(SelectedCourseDto selectedCourseDto : selectedCourseDtoList){
            ids.add(selectedCourseDto.getCourseId());
        }
        List<CoursePo> coursePoList = courseService.getCourseById(ids);
        return coursePoList;
    }


    /**
     * 添加考勤签到
     * @param attendance
     * @return
     */
    @PostMapping("/addAttendance")
    @ResponseBody
    public AjaxResult addAttendance(AttendanceDto attendance){
        AjaxResult ajaxResult = new AjaxResult();
        attendance.setDate(DateFormatUtil.getFormatDate(new Date(),"yyyy-MM-dd"));
        //判断是否已签到
        if(attendanceService.isAttendance(attendance)){
            //true为已签到
            ajaxResult.setSuccess(false);
            ajaxResult.setMessage("已签到，请勿重复签到！");
        }else{
            int count = attendanceService.addAttendance(attendance);
            if(count > 0){
                //签到成功
                ajaxResult.setSuccess(true);
                ajaxResult.setMessage("签到成功");
            }else{
                ajaxResult.setSuccess(false);
                ajaxResult.setMessage("系统错误，请重新签到");
            }
        }
        return ajaxResult;
    }

    /**
     * 删除考勤签到
     * @param id
     * @return
     */
    @PostMapping("/deleteAttendance")
    @ResponseBody
    public AjaxResult deleteAttendance(String id){
        AjaxResult ajaxResult = new AjaxResult();
        try {
            int count = attendanceService.deleteAttendance(id);
            if(count > 0){
                ajaxResult.setSuccess(true);
                ajaxResult.setMessage("删除成功");
            }else{
                ajaxResult.setSuccess(false);
                ajaxResult.setMessage("删除失败");
            }
        } catch (Exception e) {
            ajaxResult.setSuccess(false);
            ajaxResult.setMessage("系统异常,请重试");
            e.printStackTrace();
        }
        return ajaxResult;
    }
}
