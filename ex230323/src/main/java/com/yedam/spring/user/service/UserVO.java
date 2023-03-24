package com.yedam.spring.user.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class UserVO {
	private String name;
	private Integer age;
	// java.util.Date는 포맷이 / 이다
	// java.sql.Date는 포맷이 - 이다
	
	// 출력과는 상관없음, 입력받을때의 패턴을 정할 수 있다. 시간까지 받으려면 HH:mm:ss 도 입력
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date today;
	
	private MultipartFile pic;
}
