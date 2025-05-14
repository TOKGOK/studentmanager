package com.wdd.studentManager.common.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;


@Data
public class BaseVo {

    @Schema(title = "主键ID")
    private String id;
}
