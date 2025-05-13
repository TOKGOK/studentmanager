package com.wdd.studentManager.domain;

import lombok.Data;
import org.springframework.stereotype.Component;


@Component
@Data
public class Grade {
	private String id;
	private String name;
	private String remark;//��ע
}
