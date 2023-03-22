package com.yedam.app.spring;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		// xml 파일의 컨테이너를 만들기 위해 이작업이 필요함
		// 컨테이너를 만드는 클래스고 xml 파일을 통하여 bean을 들고온다
		GenericXmlApplicationContext ctx = //
				new GenericXmlApplicationContext("classpath:applicationContext.xml");
		
		// TV가 오브젝트니 TV타입이라고 정해줌
		// Bean을 읽어올거니 getBean하고 Bean을 선언한 id의 값을 넣어 불러온다.
		TV tv = (TV) ctx.getBean("tv");
		tv.on();
		
	}

}
