package com.yedam.mapper;

import java.util.List;

import com.yedam.vo.BoardVO;

public interface BoardMapper {
	List<BoardVO> boardList(); //목록
	int insertBoard(BoardVO board);
	BoardVO selectBoard(int boardNo);
	int updateViewCnt(int boardNo);
	int modifyBoard(BoardVO board);
	int deleteBoard(int boardNo);
	
}
