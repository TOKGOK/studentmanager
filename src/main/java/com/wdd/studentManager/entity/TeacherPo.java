package com.wdd.studentManager.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.wdd.studentManager.common.entity.BasePo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("s_teacher")
public class TeacherPo extends BasePo {
    private String sn;//学号
    private String username;
    private String password;
    private String clazzId;
    private String sex = "男";
    private String mobile;
    private String qq;
    private String photo;//头像
}
