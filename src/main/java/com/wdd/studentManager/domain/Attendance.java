package com.wdd.studentManager.domain;

import lombok.Data;

/**
 * @Classname Attendance
 * @Description 考勤实体类
 * @Date 2019/7/1 11:52
 * @Created by WDD
 */
@Data
public class Attendance {
    private String id;
    private String courseId;
    private String studentId;
    private String type;
    private String date;

}
