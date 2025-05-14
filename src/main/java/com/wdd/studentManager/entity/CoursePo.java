package com.wdd.studentManager.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.wdd.studentManager.common.entity.BasePo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @Classname Course
 * @Description None
 * @Date 2019/6/29 20:06
 * @Created by WDD
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("s_course")
public class CoursePo extends BasePo {

    private String name;
    private String teacherId;
    private String courseDate;
    private int selectedNum = 0;//已选人数
    private int maxNum = 50;//课程最大选课人数
    private String info;
}
