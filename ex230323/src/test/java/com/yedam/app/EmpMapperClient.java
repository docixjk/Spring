package com.yedam.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yedam.spring.emp.mapper.EmpMapper;
import com.yedam.spring.emp.service.EmpVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/spring/**/*-context.xml")
public class EmpMapperClient {
	@Autowired
	EmpMapper empMapper;
	
	@Test
	public void selectAllEmp() {
		// 전체 졸회
		List<EmpVO> emplist = empMapper.selectEmpAllList();
		assertNotNull(emplist);
	}
	
	@Test
	public void selectEmpInfo() {
		// 단건 조회
		EmpVO empVO = new EmpVO();
		empVO.setEmployeeId(100);
		
		EmpVO findVO = empMapper.selectEmpInfo(empVO);
		assertEquals(findVO.getLastName(),"King");
	}
	
	@Test
	public void insertEmpInfo() {
		// 사원 등록
		EmpVO empVO = new EmpVO();
		empVO.setLastName("Pack");
		empVO.setFirstName("Suna");
		empVO.setEmail("xkq3355@naver.com");
		empVO.setJobId("IT_PROG");
		empVO.setSalary(5000);
		
		empMapper.insertEmpInfo(empVO);
		assertNotEquals(empVO.getEmployeeId(),0);
	}
	
	@Test
	public void updateEmpSal() {
		// 급여 갱신
		int result = empMapper.updateEmpSal(1000, 10);
		assertEquals(result,1);
	}
	
	@Test
	public void updateEmpInfo() {
		// 사원 정보 수정
		EmpVO empVO = new EmpVO();
		empVO.setEmployeeId(1000);
		
		
		EmpVO findVO = empMapper.selectEmpInfo(empVO);
		empVO.setEmail("xkq3355xkq@naver.com");
		empVO.setSalary(7000);
		
		int result = empMapper.updateEmpInfo(empVO);
		assertEquals(result,1);
	}
	
	@Test
	public void deleteEmpInfo() {
		// 사원 삭제
		int result = empMapper.deleteEmpInfo(999);
		assertEquals(result,1);
	}
	
}
