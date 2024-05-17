package com.yedam.web;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.ReplyService;
import com.yedam.service.ReplyServiceImpl;
import com.yedam.vo.ReplyVO;

public class ModifyReplyControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String reply = req.getParameter("reply");
		String replyNo = req.getParameter("replyNo");
		
		ReplyService svc = new ReplyServiceImpl();
	    ReplyVO vo = new ReplyVO();
	    vo.setReplyNo(Integer.parseInt(replyNo));
	    vo.setReply(reply);
	    
	    if(svc.modifyReply(vo)) {
	    	 resp.getWriter().print("{\"retCode\": \"OK\"}");
	    }else {
	    	 resp.getWriter().print("{\"retCode\": \"NG\"}");
	    	 
	    	 
	    }
				
	}

}
