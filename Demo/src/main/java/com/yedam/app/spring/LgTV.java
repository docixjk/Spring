package com.yedam.app.spring;

public class LgTV implements TV {

	@Override
	public void on() {
		System.out.println("스프링 방식으로 LgTV 켬");
	}

}
