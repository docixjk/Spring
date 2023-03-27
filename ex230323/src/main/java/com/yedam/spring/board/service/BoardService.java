package com.yedam.spring.board.service;

import java.util.List;
import java.util.Map;

public interface BoardService {

	// 전체조회
	public List<BoardVO> getBoardList();
	
	// 단건조회
	public BoardVO getBoard(BoardVO boardVO);
	
	// 등록하고자 하는 글번호
	public BoardVO getBoardNo();
	
	// 등록
	public int insertBoard(BoardVO boardVO);
	
	// 수정
	public Map<String, String> updateBoard(BoardVO boardVO);
	
	// 삭제
	public Map<String, String> deleteBoard(int bno);
}
