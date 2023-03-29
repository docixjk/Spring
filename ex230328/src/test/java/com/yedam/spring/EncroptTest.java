package com.yedam.spring;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; // 암호화 , 복호화의 기준이 됨

public class EncroptTest {
	
	@Test
	public void test() {
		BCryptPasswordEncoder scpwd = new BCryptPasswordEncoder();
		String password = scpwd.encode("1234");
		System.out.println(password);
	}

}
