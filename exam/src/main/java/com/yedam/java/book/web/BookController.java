package com.yedam.java.book.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yedam.java.book.service.BookService;
import com.yedam.java.book.service.BookVO;

@Controller
public class BookController {
	@Autowired
	BookService bookService;
	

	@GetMapping("bookList")
	public String bookList(Model model) {
		model.addAttribute("bookList", bookService.getBookList());
		return "book/bookList";
	}
	
	@GetMapping("bookInsert")
	public String bookInsertForm(Model model) {
		model.addAttribute("bookVO", new BookVO());
		model.addAttribute("bookNo", bookService.getBookNo().getBookNo());
		return "book/bookInsert";
	}
	
	@PostMapping("bookInsert")
	public String bookInsertProcess(BookVO bookVO, RedirectAttributes rrtt) {
		int r = bookService.insertBook(bookVO);
		
		
		String result = null;
		
		if(r == -1) {
			result = "정상적으로 등록되지 않았습니다.";
		}else {
			result = "정상적으로 등록되었습니다.";
		}
		
//		model.addAttribute("result",result); // model을 쓰면 데이터 손실이 있을수 있다.
		rrtt.addFlashAttribute("result",result);
		
		return "redirect:bookList"; // 컨트롤러 요청하기
		
	}
	
	@GetMapping("RentList")
	public String RentList(Model model) {
		model.addAttribute("RentList", bookService.getRentList());
		return "book/RentList";
	}
	
}
