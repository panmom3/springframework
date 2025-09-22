package com.spring.springGroupS.vo;

import lombok.Data;

@Data
public class ComplaintVO {
	private int idx;
	private String part;
	private int partIdx; /* 신고 분류항목 글의 고유번호 */
	private String cpMid; /* 신고자 아이디 */
	private String cpContent;
	private String cpDate;
	private String progress;
	
	private String title;
	private String nickName;
	private String content;
	private String mid;
	private String complaint;
	private String complaintSw;
	
}
