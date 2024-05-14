package com.yedam.common;

import lombok.Data;

@Data
public class SearchVO {
	//게시글에 관한 정보
	private int page;
	private String searchCondition;
	private String keyword;
	
	//댓글관련
	private int boardNo;
	private int rpage;
	
}
