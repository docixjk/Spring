package com.yedam.spring.emp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yedam.spring.emp.service.EmpVO;

public interface EmpMapper {
	// SQL문 하나를 매핑하는 것 : 메소드 하나 -> sql문 하나
	// 전체조회
	public List<EmpVO> selectEmpAllList();
	
	// 단건조회
	public EmpVO selectEmpInfo(EmpVO empVO);
	
	// 등록
	public int insertEmpInfo(EmpVO empVO); 
	
	// 수정 - 급여를 정해진 비율로 인상
	// @Param은 Mybatis에서 지원하는 어노테이션이다 (" ")내용이 SQL에서 쓰이는거임
	// 다른 하나가 클래스가 된다면 #{클래스.변수} 로 적으면된다.
	public int updateEmpSal(@Param("empId") int employeeId,
			                @Param("raise")int raise);
	
	// 수정 - 사원 정보 수정
	public int updateEmpInfo(EmpVO empVO);
	
	// 삭제
	public int deleteEmpInfo(int employeeId);
	
}
