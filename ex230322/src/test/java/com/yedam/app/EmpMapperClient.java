package com.yedam.app;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yedam.app.emp.mapper.EmpMapper;
import com.yedam.app.emp.service.EmpVO;

@RunWith(SpringJUnit4ClassRunner.class)
// 여기서 사용하는 xml 파일의 경로가 다르니 따로 설정하자
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class EmpMapperClient {
	@Autowired
	EmpMapper empMapper;
	
	@Test
	public void getEmpInfo() {
		EmpVO vo = new EmpVO();
		vo.setEmployee_id("100");
		EmpVO findVO = empMapper.getEmp(vo);
		assertEquals(findVO.getFirst_name(),"Steven");
	}
}
