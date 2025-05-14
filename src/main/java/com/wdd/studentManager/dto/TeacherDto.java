package com.wdd.studentManager.dto;

import com.wdd.studentManager.common.dto.BaseDto;
import lombok.Data;

/**
 * @Classname Teacher
 * @Description None
 * @Date 2019/6/28 18:55
 * @Created by WDD
 */
@Data
public class TeacherDto extends BaseDto {
    private String sn;//学号
    private String username;
    private String password;
    private String clazzId;
    private String sex = "男";
    private String mobile;
    private String qq;
    private String photo;//头像


}
