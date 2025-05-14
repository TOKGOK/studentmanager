package com.wdd.studentManager.dto;

import com.wdd.studentManager.common.dto.BaseDto;
import lombok.Data;

@Data
public class AdminDto extends BaseDto {

    private String username;

    private String password;
}
