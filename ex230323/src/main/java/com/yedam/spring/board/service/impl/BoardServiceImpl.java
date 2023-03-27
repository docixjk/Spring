package com.yedam.spring.board.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.spring.board.mapper.BoardMapper;
import com.yedam.spring.board.service.BoardService;
import com.yedam.spring.board.service.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardMapper boardMapper;
	
	@Override // 전체조회
	public List<BoardVO> getBoardList() {
		return boardMapper.boardAllList();
	}

	@Override // 단건조회
	public BoardVO getBoard(BoardVO boardVO) {
		return boardMapper.selectBoard(boardVO);
	}

	@Override // 작성하는 글번호 알아내기
	public BoardVO getBoardNo() {
		return boardMapper.getBoardNo();
	}

	@Override // 등록한 글번호 반환
	public int insertBoard(BoardVO boardVO) {
		int result = boardMapper.insertBoard(boardVO);

		if (result == 1) {
			return boardVO.getBno();
		}else {
			return -1;
		}
	}

	@Override // 수정한 글번호 반환
	public int updateBoard(BoardVO boardVO) {
		
		
		int result = boardMapper.updateBoard(boardVO);
		
		if(result == 1) {
			return boardVO.getBno();
		}else {
			return -1;
		}
	}

	@Override
	public int deleteBoard(int bno) {
		int result = boardMapper.deleteBoard(bno);

		if(result == 1) {
			return bno;
		}else {
			return -1;
		}
	}

	
}
