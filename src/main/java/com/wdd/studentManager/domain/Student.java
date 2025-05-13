package com.wdd.studentManager.domain;

import lombok.Data;

@Data
public class Student {
	private String id;
	private String sn;//学号
	private String username;
	private String password;
	private String clazzId;
	private String sex = "男";
	private String mobile;
	private String qq;
	private String photo;//头像


}
