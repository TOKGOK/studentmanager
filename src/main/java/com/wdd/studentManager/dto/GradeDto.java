package com.wdd.studentManager.dto;

import com.wdd.studentManager.common.dto.BaseDto;
import lombok.Data;
import org.springframework.stereotype.Component;


@Component
@Data
public class GradeDto extends BaseDto {
	private String name;
	private String remark;
}
