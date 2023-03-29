package com.yedam.boot.emp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yedam.boot.emp.service.EmpService;
import com.yedam.boot.emp.service.EmpVO;

@Controller
public class EmpController {
	
	@Autowired
	EmpService empService;
	
	// 경로가 empList 고 메소드 방식은 GET
	@RequestMapping(value="empList", method=RequestMethod.GET)
	public String empAllList(Model model) {
		model.addAttribute("empList", empService.getEmpList());
		return "empList";
	}
	
	@GetMapping("empInfo")
	public String empInfo(EmpVO empVO, Model model) {
		model.addAttribute("empInfo", empService.getEmpInfo(empVO));
		return "empInfo";
	}
	
	@GetMapping("empInsert")
	public String empInsertForm(Model model) {
		// 안에서 사용될 객체를 보내줌 ( 페이지를 요청할때 오브젝트에 사용되는 객체를 보내준다 )
		model.addAttribute("empVO", new EmpVO());
		return "empInsert";
	}
	
	@PostMapping("empInsert")
	public String empInsertProcess(EmpVO empVO) {
		empService.insertEmpInfo(empVO);
		return "redirect:empList";
	}
}
