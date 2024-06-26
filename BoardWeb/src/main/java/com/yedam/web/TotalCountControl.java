package com.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.ReplyService;
import com.yedam.service.ReplyServiceImpl;

public class TotalCountControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String bno = req.getParameter("bno");
		//service, mapper
		
		ReplyService svc = new ReplyServiceImpl();
		int cnt = svc.TotalCount(Integer.parseInt(bno));
		
		// {"totalCount": 10}
		resp.getWriter().print("{\"totalCount\":" + cnt + "}");
		
		
	}

}
