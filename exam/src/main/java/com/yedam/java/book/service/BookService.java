package com.yedam.java.book.service;

import java.util.List;

public interface BookService {
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
