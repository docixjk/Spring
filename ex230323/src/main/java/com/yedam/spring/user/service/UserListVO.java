package com.yedam.spring.user.service;

import java.util.List;

import lombok.Data;

@Data
public class UserListVO {
	private List<UserVO> list; // UserVO를 거쳐 넘겨진다
}
