package com.yedam.vo;

import lombok.Data;

@Data
public class BoardVO {
	private int boardNo;
	private String title;
	private String content;
	private String writer;
	private String createDate;
	private int viewCnt;

}
