package com.yedam.common;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.mapper.BoardMapper;
import com.yedam.mapper.ReplyMapper;
import com.yedam.service.BoardServiceImpl;
import com.yedam.service.BoardService;
import com.yedam.vo.BoardVO;

public class BoardTest {
	public static void main(String[] args) {
	
	SqlSession session = DataSource.getInstance().openSession(true);
	ReplyMapper mapper = session.getMapper(ReplyMapper.class);
	
		mapper.replyList(12).forEach(reply -> System.out.println(reply));
	
	
	}
}
