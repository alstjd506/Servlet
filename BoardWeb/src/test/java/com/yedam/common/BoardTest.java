package com.yedam.common;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.mapper.BoardMapper;
import com.yedam.mapper.ReplyMapper;
import com.yedam.service.BoardServiceImpl;
import com.yedam.service.BoardService;
import com.yedam.vo.BoardVO;
import com.yedam.vo.CartVO;

public class BoardTest {
	public static void main(String[] args) {
	
	SqlSession session = DataSource.getInstance().openSession(true);
	ReplyMapper mapper = session.getMapper(ReplyMapper.class);

	CartVO cvo = new CartVO();
	cvo.setNo(1);
	cvo.setQty(1);
	int r = mapper.deleteCart(cvo.getNo());
	System.out.println("건수: " +r);
	
	mapper.selectList().forEach(cart -> System.out.println(cart));
	
	
	}
}
