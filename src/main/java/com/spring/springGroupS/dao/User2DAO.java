package com.spring.springGroupS.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.spring.springGroupS.vo.UserVO;

public interface User2DAO {
	List<UserVO> getUserList();

	List<UserVO> getUserSearch(String mid);

	int setUserInput(@Param("vo") UserVO vo);

	int setUserDelete(@Param("idx") int idx);  //XML에서 #{idx}로 사용

	UserVO getUserIdxSearch(@Param("idx") int idx);

	int setUserUpdate(UserVO vo);

}
