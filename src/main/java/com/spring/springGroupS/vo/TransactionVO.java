package com.spring.springGroupS.vo;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

import lombok.Data;

@Data
public class TransactionVO {
	private int idx;
	
	//@NotEmpty(message = "아이디가 공백입니다.") 
	@Size(min=3, max=20, message= "아이디 길이 오류(아이디는 3~20자까지 입력)")
	private String mid;
	
	@Size(min=2, max=20, message= "성명 길이 오류(성명은 2~20자까지 입력)")
	private String name;
	
	@Range(min=18, max=99, message= "나이 범위 오류(아이디는 18~99자까지 입력)")
	private int age;
	
	private String address;
	
	private String job;
}
