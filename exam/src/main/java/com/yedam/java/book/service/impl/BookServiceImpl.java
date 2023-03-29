package com.yedam.java.book.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.java.book.mapper.BookMapper;
import com.yedam.java.book.service.BookService;
import com.yedam.java.book.service.BookVO;
import com.yedam.java.book.service.RentVO;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	BookMapper bookMapper;
	
	@Override
	public List<BookVO> getBookList() {
		return bookMapper.getBookList();
	}

	@Override
	public BookVO getBookInfo(BookVO bookVO) {
		return bookMapper.getBookInfo(bookVO);
	}

	@Override
	public List<RentVO> getRentList() {
		return bookMapper.getRentList();
	}

	@Override
	public int insertBook(BookVO bookVO) {
		return bookMapper.insertBook(bookVO);
	}

	@Override
	public BookVO getBookNo() {
		return bookMapper.getBookNo();
	}

}
