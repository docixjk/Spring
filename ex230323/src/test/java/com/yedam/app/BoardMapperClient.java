package com.yedam.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yedam.spring.board.mapper.BoardMapper;
import com.yedam.spring.board.service.BoardVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/spring/**/*-context.xml")
public class BoardMapperClient {
	@Autowired
	BoardMapper boardMapper;
	
	@Test
	public void boardAllList() {
		// 전체 조회
		List<BoardVO> boardList = boardMapper.boardAllList();
		assertNotNull(boardList);
	}
	
	@Test
	public void selectBoard() {
		// 단건 조회
		BoardVO boardVO = new BoardVO();
		boardVO.setBno(2);
		boardVO.setWriter("seoki");
		
		BoardVO findVO = boardMapper.selectBoard(boardVO);
		assertEquals(findVO.getWriter(),"seoki");
	}
	
	@Test
	public void getBoardNo() {
		
		BoardVO findVO = boardMapper.getBoardNo();
		assertEquals(findVO.getBno(),5);
	}
	 
	@Test
	public void insertBoard() {

		BoardVO findVO = boardMapper.getBoardNo();
		// 글 등록
		BoardVO boardVO = new BoardVO();
		boardVO.setBno(findVO.getBno());
		boardVO.setTitle("제목5");
		boardVO.setContents("내용5");
		boardVO.setWriter("sunaisking");
		boardVO.setImage("image5.jpg");
		
		
		boardMapper.insertBoard(boardVO);
		assertNotEquals(boardVO.getBno(),0);
	}
	
	
	@Test
	public void updateBoard() {
		//  수정
		BoardVO boardVO = new BoardVO();
		boardVO.setBno(1);
		
		
		BoardVO findVO = boardMapper.selectBoard(boardVO);
		boardVO.setTitle("수정제목1");
		boardVO.setContents("수정내용1");
		
		int result = boardMapper.updateBoard(boardVO);
		assertEquals(result,1);
	}
	
	@Test
	public void deleteBoard() {
		// 삭제
		int result = boardMapper.deleteBoard(4);
		assertEquals(result,1);
	}
}
