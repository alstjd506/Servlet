package com.yedam.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.common.Control;
import com.yedam.common.SearchVO;
import com.yedam.service.ReplyService;
import com.yedam.service.ReplyServiceImpl;
import com.yedam.vo.ReplyVO;

public class ReplyListControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//json 포멧의 데이터를 반환.
		resp.setContentType("text/json;charset=utf-8");
		
		String bno = req.getParameter("bno");
		String rpage = req.getParameter("page");
		
		//rpage값이 null이면 1페이지
		rpage = rpage == null ? "1" : rpage;
				
		SearchVO search = new SearchVO();
		search.setBoardNo(Integer.parseInt(bno));
		search.setRpage(Integer.parseInt(rpage));
		
		ReplyService svc = new ReplyServiceImpl();
		List<ReplyVO> list = svc.replyList(search);
		
		Gson gson = new GsonBuilder().create();
		String json = gson.toJson(list);
		
		resp.getWriter().print(json);
		
		
		
	}

}
