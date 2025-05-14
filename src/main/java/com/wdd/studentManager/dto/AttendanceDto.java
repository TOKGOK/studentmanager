package com.wdd.studentManager.dto;

import com.wdd.studentManager.common.dto.BaseDto;
import lombok.Data;

@Data
public class AttendanceDto extends BaseDto {

    private String courseId;
    private String studentId;
    private String type;
    private String date;
}
