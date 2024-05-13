package com.yedam.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yedam.common.SearchVO;
import com.yedam.vo.BoardVO;
import com.yedam.vo.MemberVO;

public interface BoardMapper {
	List<BoardVO> boardList(); //목록
	List<BoardVO> boardListPaging(SearchVO search); //페이징 목록
	int getTotalCnt(SearchVO search);
	
	int insertBoard(BoardVO board);
	BoardVO selectBoard(int boardNo);
	int updateViewCnt(int boardNo);
	int modifyBoard(BoardVO board); //수정처리.
	int deleteBoard(int boardNo); //삭제처리.
	
	//사용자id, pw 확인.
	MemberVO selectMember(@Param("id") String id, @Param("pw") String pw);
	MemberVO selectMember2(String id);
	
}
