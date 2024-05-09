package com.yedam.service;

import java.util.List;

import com.yedam.vo.BoardVO;

public interface BoardService {
	List<BoardVO> boardList();
	boolean addBoard(BoardVO board);
	BoardVO getBoard(int boardNo);
	int addViewCnt(int boradNo);
	boolean modifyBoard(BoardVO board);
	int deleteBoard(int boardNo);
		
}
