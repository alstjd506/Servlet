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
	BoardVO vo = new BoardVO();
	vo.setBoardNo((3));
	vo.setTitle("adfdf");
	vo.setContent("asdfsdf");
		
	if(svc.modifyBoard(vo)) {
		System.out.println("성공");
	}else {
		System.out.println("실패");
	}
	}
}
