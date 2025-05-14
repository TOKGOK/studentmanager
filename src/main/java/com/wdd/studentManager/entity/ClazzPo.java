package com.wdd.studentManager.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import com.wdd.studentManager.common.entity.BasePo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 班级实体类
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("s_clazz")
public class ClazzPo extends BasePo {

    private String name;
    private String info;
}
