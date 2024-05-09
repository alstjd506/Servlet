package com.yedam.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.apache.ibatis.session.SqlSession;

import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;
import com.yedam.common.Control;
import com.yedam.common.DataSource;

public class MainControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path = "WEB-INF/board/boardList.jsp";
		resp.setContentType("text/html; charset=utf-8");
		resp.setCharacterEncoding("utf-8");
		
		BoardService svc = new BoardServiceImpl();
		List<BoardVO> list = svc.boardList();
		
		//jsp에
		req.setAttribute("boardList", list);
		req.getRequestDispatcher(path).forward(req, resp);

	}

}
