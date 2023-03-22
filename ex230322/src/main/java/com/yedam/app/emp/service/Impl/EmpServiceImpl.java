package com.yedam.app.emp.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.app.emp.mapper.EmpMapper;
import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.service.EmpVO;

@Service // EmpService를 쓰기위에 Service 어노테이션을 사용한다
public class EmpServiceImpl implements EmpService {
	@Autowired
	EmpMapper empMapper;
	
	@Override
	public EmpVO getEmpInfo(EmpVO empVO) {
		return empMapper.getEmp(empVO);
	}
	
}
