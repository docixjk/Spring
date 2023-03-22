package com.yedam.app;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yedam.app.junit.Restaurant;

// 테스트할때 xml에서 들고와 컨테이너를 만들어줌
@RunWith(SpringJUnit4ClassRunner.class)
// 컨테이너를 이루는 정보 xml 둘 다 있어야함
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestClass {
	
//	@Autowired // 타입은 보통 인터페이스 , 빈으로 구현클래스를 사용할때 사용할 위치에 인터페이스로 쓰자 
//	ApplicationContext ctx;
	
	@Autowired // 필드로도 사용 가능
	Restaurant res;
	
	@Test
	public void beanTest() {
		// ctx 에서 빈을 가져오는건 맞는데 클래스 전체를 넘겨줌
		// 빈이 어떤 클래스인지 넘겨주면 된다 (.class를 하면 class에 대한 정보를 넘겨줌)
//		Restaurant res = ctx.getBean(Restaurant.class);
		assertNotNull(res);
	}
}
