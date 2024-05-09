package com.yedam.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.mapper.BoardMapper;
import com.yedam.vo.BoardVO;

public class BoardServiceImpl implements BoardService {
	
	SqlSession session = DataSource.getInstance().openSession(true);
	BoardMapper mapper = session.getMapper(BoardMapper.class);
	
	@Override
	public List<BoardVO> boardList(){
		return mapper.boardList();
	}

	@Override
	public boolean addBoard(BoardVO board) {
		return mapper.insertBoard(board) == 1;	
		
	}

	@Override
	public BoardVO getBoard(int boardNo) {
		return mapper.selectBoard(boardNo);
	
	}

	@Override
	public int addViewCnt(int boradNo) {
		return mapper.updateViewCnt(boradNo);
	
		
	}

	@Override
	public boolean modifyBoard(BoardVO board) {
		return mapper.modifyBoard(board) == 1;
	}

	@Override
	public int deleteBoard(int boardNo) {
		// TODO Auto-generated method stub
		return mapper.deleteBoard(boardNo);
	}



}
