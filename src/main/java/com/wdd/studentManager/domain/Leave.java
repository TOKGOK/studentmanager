package com.wdd.studentManager.domain;

import lombok.Data;

/**
 * @Classname Leave
 * @Description 请假表实体类
 * @Date 2019/7/2 13:57
 * @Created by WDD
 */
@Data
public class Leave {

    private String id;
    private int studentId;
    private String info;//请假理由
    private int status;//请假条状态
    private String remark;//批复内容

}
