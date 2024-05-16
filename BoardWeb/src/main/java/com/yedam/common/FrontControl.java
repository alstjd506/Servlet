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
import com.yedam.web.AddReplyControl;
import com.yedam.web.BoardInfoControl;
import com.yedam.web.LoginControl;
import com.yedam.web.LoginForm;
import com.yedam.web.LogoutControl;
import com.yedam.web.MainControl;
import com.yedam.web.MemberListControl;
import com.yedam.web.ModifyControl;
import com.yedam.web.ModifyFormControl;
import com.yedam.web.ModifyReplyControl;
import com.yedam.web.ProductListControl;
import com.yedam.web.RemoveControl;
import com.yedam.web.RemoveFormControl;
import com.yedam.web.RemoveReplyControl;
import com.yedam.web.ReplyListControl;
import com.yedam.web.TotalCountControl;

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
		map.put("/addForm.do", new AddFromControl()); //글등록화면.
		map.put("/addBoard.do", new AddBoardControl());
		map.put("/boardInfo.do", new BoardInfoControl());
		
		//수정관련
		map.put("/modBoardForm.do", new ModifyFormControl());
		map.put("/updateBoard.do", new ModifyControl());
		
		//삭제관련
		map.put("/removeBoardForm.do", new RemoveFormControl());
		map.put("/deleteBoard.do", new RemoveControl());
		
		//로그인관련.
		map.put("/logForm.do", new LoginForm());
		map.put("/login.do", new LoginControl());
		
		//로그아웃
		map.put("/logout.do", new LogoutControl());
		
		//댓글관련.
		map.put("/replyList.do", new ReplyListControl());
		map.put("/removeReply.do", new RemoveReplyControl());
		map.put("/addReply.do", new AddReplyControl());
		map.put("/getTotalCnt.do", new TotalCountControl());
		map.put("/modifyReply.do", new ModifyReplyControl());
		
		
		//관리자권한.
		map.put("/memberList.do", new MemberListControl());
		
		//상품관련
		map.put("/productList.do", new ProductListControl());
		
		
		
	}

	// service
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//req.setCharacterEncoding("utf-8"); // 요청정보의 한글처리

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
