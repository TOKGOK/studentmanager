package com.wdd.studentManager.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import com.wdd.studentManager.common.entity.BasePo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;


/**
 * @Classname Attendance
 * @Description 考勤实体类
 * @Date 2019/7/1 11:52
 * @Created by WDD
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("s_attendance")
public class AttendancePo extends BasePo {

    private String courseId;
    private String studentId;
    private String type;
    private String date;
}
