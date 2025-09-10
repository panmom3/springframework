package com.spring.springGroupS.service;

import java.util.ArrayList;

import org.springframework.web.multipart.MultipartFile;

import com.spring.springGroupS.vo.UserVO;

public interface StudyService {

	String[] getCityStringArray(String dodo);

	ArrayList<String> getCityArrayList(String dodo);

	ArrayList<UserVO> getUserList(String mid);

	UserVO getUserMidSearch(String mid);

	ArrayList<UserVO> getUserListSearch(String mid);

	int setFileUpload(MultipartFile fName, String mid);

}
