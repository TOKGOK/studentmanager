package com.wdd.studentManager.common.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "BasePo")
public class BasePo {

    @Schema(
            description = "主键ID"
    )
    @TableId(
            value = "id",
            type = IdType.ASSIGN_UUID
    )
    private String id;

}
