package com.wdd.studentManager.dto;

import com.wdd.studentManager.common.dto.BaseDto;
import lombok.Data;

/**
 * @Classname SelectedCourse
 * @Description 选课信息实体类
 * @Date 2019/6/30 10:30
 * @Created by WDD
 */
@Data
public class SelectedCourseDto extends BaseDto {
    private String studentId;
    private String courseId;

}
