package com.wdd.studentManager.dto;

import com.wdd.studentManager.common.dto.BaseDto;
import lombok.Data;

@Data
public class StudentDto extends BaseDto {
	private String sn;//学号
	private String username;
	private String password;
	private String clazzId;
	private String sex = "男";
	private String mobile;
	private String qq;
	private String photo;//头像

}
