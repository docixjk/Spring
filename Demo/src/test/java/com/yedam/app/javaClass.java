package com.yedam.app;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.yedam.app.java.SamsungTV;
import com.yedam.app.java.TV;

public class javaClass {
	
	// method로 test해야함
	@Test
	public void method() {
		System.out.println("단순 테스트");
	}
	
	@Test
	public void javaTest() {
		TV tv = new SamsungTV();
		// 기능적으로 확인하는 경우가 많음
		assertNotNull(tv);
	}
}
