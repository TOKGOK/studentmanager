package com.wdd.studentManager.dto;

import com.wdd.studentManager.common.dto.BaseDto;
import lombok.Data;

/**
 * @Classname Leave
 * @Description 请假表实体类
 * @Date 2019/7/2 13:57
 * @Created by WDD
 */
@Data
public class LeaveDto extends BaseDto {

    private String studentId;
    private String info;//请假理由
    private int status;//请假条状态
    private String remark;//批复内容

}
