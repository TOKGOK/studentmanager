package com.wdd.studentManager.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.wdd.studentManager.common.entity.BasePo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("s_score")
public class ScorePo extends BasePo {
    private String studentId;
    private String courseId;
    private double score;
    private String remark;

    //关联表
    private String courseName;
    private String studentName;
}
