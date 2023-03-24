package com.yedam.spring.emp.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yedam.spring.emp.service.EmpService;
import com.yedam.spring.emp.service.EmpVO;

@Controller
public class EmpController {
	@Autowired
	EmpService empService;
	
	// 조회(데이터, 일반페이지) -> GET
	// 등록, 수정, 삭제 -> POST
	
	// 전체조회
	@GetMapping("/empList")
	public String getEmpAllList(Model model) { // 페이지를 보낼거니 스트링
		model.addAttribute("empList",empService.getEmpAll());
		return "emp/empList";
	}
	
	// 단건조회
	@GetMapping("/empInfo")
	public String getEmpInfo(EmpVO empVO, Model model) {
		model.addAttribute("empInfo", empService.getEmp(empVO));
		return "emp/empInfo";
	}
	
	// 등록 - Form : 유일한 경로를 가져야함
	@GetMapping("/empInsert")
	public String empInsertForm() {
		return "emp/empInsert";
	}
	
	// 등록 - Process
	@PostMapping("/empInsert")
	public String empInsertProcess(EmpVO empVO, RedirectAttributes rrtt) {
		int empId = empService.insertEmp(empVO);
		
		String result = null;
		
		if(empId == -1) {
			result = "정상적으로 등록되지 않았습니다.";
		}else {
			result = "정상적으로 등록되었습니다.\n"
				   + "등록된 사원의 사번은 "+ empId + " 입니다.";
		}
		
//		model.addAttribute("result",result); // model을 쓰면 데이터 손실이 있을수 있다.
		rrtt.addFlashAttribute("result",result);
		
		return "redirect:empList"; // 컨트롤러 요청하기
	}
	
	// 수정 - Process 
	// 1) Client - JSON -> Server
	// 2) Server - text -> Client
	@PostMapping("/empUpdate")
	@ResponseBody
	public Map<String, String> empUpdateProcess(@RequestBody EmpVO empVO) {
		return empService.updateEmp(empVO);
	}
	
	
	
	
	
	
	
	
}
