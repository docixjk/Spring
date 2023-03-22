package com.yedam.app.emp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.service.EmpVO;

@Controller // 예전에 사용한 frontController와 같은 역할
public class EmpController {
	@Autowired
	EmpService empService;
	
	// 경로
	@RequestMapping("/getEmpInfo")
	@ResponseBody
	public EmpVO getEmpInfo(EmpVO empVO) {
		// 하나의 메소드가 하나의 경로로 되게 한다
		return empService.getEmpInfo(empVO);
	}
}
