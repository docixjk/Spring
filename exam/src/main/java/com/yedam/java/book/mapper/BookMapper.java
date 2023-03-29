package com.yedam.java.book.mapper;

import java.util.List;

import com.yedam.java.book.service.BookVO;
import com.yedam.java.book.service.RentVO;

public interface BookMapper {
	// 도서 목록
	public List<BookVO> getBookList();
	// 도서 상세
	public BookVO getBookInfo(BookVO bookVO);
	// 도서 대여현황
	public List<RentVO> getRentList();
	// 다음 도서등록 번호
	public BookVO getBookNo();
	// 도서 등록
	public int insertBook(BookVO bookVO);
}
