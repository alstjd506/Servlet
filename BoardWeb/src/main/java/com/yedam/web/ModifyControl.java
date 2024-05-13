package com.yedam.web;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class ModifyControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// bno, title, content 3개 파라미터. 목록으로 이동
		String bno = req.getParameter("bno");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String page = req.getParameter("page");
		
		String sc = req.getParameter("serachCondition");
		String kw = req.getParameter("keyword");
				
		BoardService svc = new BoardServiceImpl();
		String encodeKW = URLEncoder.encode(kw, "UTF-8");
		BoardVO vo = new BoardVO();
		vo.setBoardNo(Integer.parseInt(bno));
		vo.setTitle(title);
		vo.setContent(content);
		
		if(svc.modifyBoard(vo)) {
			System.out.println("성공");
			resp.sendRedirect("main.do?page="+page+"&serachCondition=" + sc + "&keyword=" + encodeKW );
		}else {
			System.out.println("실패");
			resp.sendRedirect("modBardForm.do");
		}
		
	}

}
