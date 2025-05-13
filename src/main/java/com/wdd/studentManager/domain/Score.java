package com.wdd.studentManager.domain;

import lombok.Data;

/**
 * @Classname score
 * @Description 成绩实体表
 * @Date 2019/7/3 10:22
 * @Created by WDD
 */
@Data
public class Score {
    private String id;
    private String studentId;
    private String courseId;
    private double score;
    private String remark;

    //关联表
    private String courseName;
    private String studentName;


}
