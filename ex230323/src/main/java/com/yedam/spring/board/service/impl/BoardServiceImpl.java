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
	
	@Override
	public List<BoardVO> getBoardList() {
		return boardMapper.boardAllList();
	}

	@Override
	public BoardVO getBoard(BoardVO boardVO) {
		return boardMapper.selectBoard(boardVO);
	}

	@Override
	public BoardVO getBoardNo() {
		return boardMapper.getBoardNo();
	}

	@Override
	public int insertBoard(BoardVO boardVO) {
		int result = boardMapper.insertBoard(boardVO);

		if (result == 1) {
			return boardVO.getBno();
		}else {
			return -1;
		}
	}

	@Override
	public Map<String, String> updateBoard(BoardVO boardVO) {
		Map<String, String> map = new HashMap<>();
		
		// map은 여러가지 정보를 넘길 수 있다.
		map.put("글번호", String.valueOf(boardVO.getBno()));
		
		int result = boardMapper.updateBoard(boardVO);
		
		if(result == 1) {
			map.put("결과", "Success");
		}else {
			map.put("결과", "Fail");
		}
		return map;
	}

	@Override
	public Map<String, String> deleteBoard(int bno) {
		Map<String, String> map = new HashMap<>();
		map.put("글번호", String.valueOf(bno));
		
		int result = boardMapper.deleteBoard(bno);

		if(result == 1) {
			map.put("결과", "Success");
		}else {
			map.put("결과", "Fail");
		}
		return map;
	}

	
}
