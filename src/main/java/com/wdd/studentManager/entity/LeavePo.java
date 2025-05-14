package com.wdd.studentManager.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.wdd.studentManager.common.entity.BasePo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("s_leave")
public class LeavePo extends BasePo {

    private String studentId;
    private String info;//请假理由
    private int status;//请假条状态
    private String remark;//批复内容
}
