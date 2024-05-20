package com.yedam.service;

import java.util.List;

import com.yedam.common.SearchVO;
import com.yedam.vo.CartVO;
import com.yedam.vo.CenterVO;
import com.yedam.vo.ReplyVO;

public interface ReplyService {
	List<ReplyVO> replyList(SearchVO search);
	boolean removeReply(int replyNo);
	boolean addReply(ReplyVO reply);
	int TotalCount(int boardNo);
	boolean modifyReply(ReplyVO reply);
	
	// cart... 목록, 수정, 삭제
	List<CartVO> cartList();
	boolean modifyCart(CartVO cvo);
	boolean removeCart(int no);
	
	int addCenter(CenterVO[] array);
	
	
	
}
