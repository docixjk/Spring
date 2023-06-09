package com.yedam.spring.emp.service;

import java.util.List;
import java.util.Map;

public interface EmpService {
		// 전체조회
		public List<EmpVO> getEmpAll();
		
		// 단건조회
		public EmpVO getEmp(EmpVO empVO);
		
		// 등록
		public int insertEmp(EmpVO empVO); 
		
		// 수정 - 급여를 정해진 비율로 인상
		public String updateEmpSal(int employeeId, int raise);
		
		// 수정 - 사원 정보 수정
		public Map<String, String> updateEmp(EmpVO empVO);
		
		// 삭제
		public Map<String, String> deleteEmp(int employeeId);
		
}
