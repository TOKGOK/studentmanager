package com.wdd.studentManager.common.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class BaseDto {
    @Schema(title = "主键ID")
    private String id;
}
