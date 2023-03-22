package com.yedam.app.junit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component // @Autowired를 쓸경우 넣어주어야함
public class Restaurant {
	
	@Autowired
	Chef chef;
	
	public void open() {
		chef.cooking();
	}
}
