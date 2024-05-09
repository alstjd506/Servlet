package com.yedam.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.web.AddBoardControl;
import com.yedam.web.AddFromControl;
import com.yedam.web.BoardInfoControl;
import com.yedam.web.MainControl;
import com.yedam.web.ModifyControl;
import com.yedam.web.ModifyFormControl;
import com.yedam.web.RemoveControl;
import com.yedam.web.RemoveFormControl;

public class FrontControl extends HttpServlet {

	Map<String, Control> map;

	// 생성자
	public FrontControl() {
		map = new HashMap<>();

	}

	// init
	@Override
	public void init(ServletConfig config) throws ServletException {
		map.put("/main.do", new MainControl());
		map.put("/addFrom.do", new AddFromControl());
		map.put("/addBoard.do", new AddBoardControl());
		map.put("/boardInfo.do", new BoardInfoControl());
		//수정관련
		map.put("/modBoardForm.do", new ModifyFormControl());
		map.put("/updateBoard.do", new ModifyControl());
		
		//삭제관련
		map.put("/removeBoardForm.do", new RemoveFormControl());
		map.put("/deleteBoard.do", new RemoveControl());
		
	}

	// service
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8"); // 요청정보의 한글처리

		String uri = req.getRequestURI();
		String context = req.getContextPath();
		System.out.println("uri: " + uri + ", context: " + context);
		String path = uri.substring(context.length());
		System.out.println("path: " + path);

		Control control = map.get(path);
		control.exec(req, resp);

	}

	// destroy.
	@Override
	public void destroy() {

	}
}
