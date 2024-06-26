package com.yedam.service;

import java.util.List;

import com.yedam.common.SearchVO;
import com.yedam.vo.BoardVO;
import com.yedam.vo.MemberVO;

public interface BoardService {
	List<BoardVO> boardList(SearchVO search);
	int getTotal(SearchVO search);
	
	boolean addBoard(BoardVO board);
	BoardVO getBoard(int boardNo);
	int addViewCnt(int boradNo);
	boolean modifyBoard(BoardVO board);
	int deleteBoard(int boardNo);
		
	//로그인
	MemberVO login(String id, String pw);
	MemberVO cheackMember(String id);
	
}
