package com.spring.springGroupS.vo;

import lombok.Data;

//@Getter
//@Setter
//@ToString
@Data
//@AllArgsConstructor(클래스의 모든 필드를 파라미터로 받는 생성자를 자동으로 생성)
//@NoArgsConstructor(기본생성자)
//@Builder
public class HoewonVO {
	private String mid;
	private String pwd;
	private String name;
	private String gender;
	private int age;
	
	private String nickName;
	private String strGender;
}
