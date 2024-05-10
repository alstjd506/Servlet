package com.yedam.common;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.mapper.BoardMapper;
import com.yedam.service.BoardServiceImpl;
import com.yedam.service.BoardService;
import com.yedam.vo.BoardVO;

public class BoardTest {
	public static void main(String[] args) {
	

		BoardService svc = new BoardServiceImpl();
		svc.boardList(3).forEach(board -> System.out.println(board));

	
	
	
	
	}
}
