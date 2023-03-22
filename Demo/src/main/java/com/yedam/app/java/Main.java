package com.yedam.app.java;

public class Main {

	public static void main(String[] args) {
		TV tv = new SamsungTV();
		tv.on();
		TV tv2 = new LgTV();
		tv2.on();
	}

}
