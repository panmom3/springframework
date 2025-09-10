package com.spring.springGroupS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.spring.springGroupS.dao.AddressDAO;
import com.spring.springGroupS.vo.MemberVO;

public class AddressServiceImpl implements AddressService {
	@Autowired
  AddressDAO addressDAO;
	@Override
	public List<MemberVO> getAddressList() {
		// TODO Auto-generated method stub
		return addressDAO.getAddressList();
	}

}
