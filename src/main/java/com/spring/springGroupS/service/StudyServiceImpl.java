package com.spring.springGroupS.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.springGroupS.dao.StudyDAO;
import com.spring.springGroupS.vo.UserVO;

@Service
public class StudyServiceImpl implements StudyService {
	@Autowired
	StudyDAO studyDAO;

	@Override
	public String[] getCityStringArray(String dodo) {
		String[] strArray = new String[100];
		
		if(dodo.equals("서울")) {
			strArray[0] = "서초구";
			strArray[1] = "강남구";
			strArray[2] = "강서구";
			strArray[3] = "서대문구";
			strArray[4] = "관악구";
			strArray[5] = "동작구";
			strArray[6] = "마포구";
			strArray[7] = "송파구";
			strArray[8] = "노원구";
			strArray[9] = "영등포구";
		}
		else if(dodo.equals("경기")) {
			strArray[0] = "수원시";
			strArray[1] = "안양시";
			strArray[2] = "광명시";
			strArray[3] = "평택시";
			strArray[4] = "안성시";
			strArray[5] = "성남시";
			strArray[6] = "안산시";
			strArray[7] = "용인시";
			strArray[8] = "이천시";
			strArray[9] = "화성시";
		}
		else if(dodo.equals("충북")) {
			strArray[0] = "청주시";
			strArray[1] = "충주시";
			strArray[2] = "제천시";
			strArray[3] = "단양군";
			strArray[4] = "증평군";
			strArray[5] = "옥천군";
			strArray[6] = "음성군";
			strArray[7] = "영동군";
			strArray[8] = "진천군";
			strArray[9] = "괴산군";
		}
		else if(dodo.equals("충남")) {
			strArray[0] = "천안시";
			strArray[1] = "아산시";
			strArray[2] = "공주시";
			strArray[3] = "부여시";
			strArray[4] = "논산군";
			strArray[5] = "군산시";
			strArray[6] = "서산시";
			strArray[7] = "홍성군";
			strArray[8] = "금산군";
			strArray[9] = "태안시";
		}
		
		return strArray;
	}

	@Override
	public ArrayList<String> getCityArrayList(String dodo) {
		ArrayList<String> vos = new ArrayList<String>();
		
		if(dodo.equals("서울")) {
			vos.add("서초구");
			vos.add("강남구");
			vos.add("강서구");
			vos.add("서대문구");
			vos.add("관악구");
			vos.add("동작구");
			vos.add("마포구");
			vos.add("송파구");
			vos.add("노원구");
			vos.add("영등포구");
		}
		else if(dodo.equals("경기")) {
			vos.add("수원시");
			vos.add("안양시");
			vos.add("광명시");
			vos.add("평택시");
			vos.add("안성시");
			vos.add("성남시");
			vos.add("안산시");
			vos.add("용인시");
			vos.add("이천시");
			vos.add("화성시");
		}
		else if(dodo.equals("충북")) {
			vos.add("청주시");
			vos.add("충주시");
			vos.add("제천시");
			vos.add("단양군");
			vos.add("증평군");
			vos.add("옥천군");
			vos.add("음성군");
			vos.add("영동군");
			vos.add("진천군");
			vos.add("괴산군");
		}
		else if(dodo.equals("충남")) {
			vos.add("천안시");
			vos.add("아산시");
			vos.add("공주시");
			vos.add("부여시");
			vos.add("논산군");
			vos.add("군산시");
			vos.add("서산시");
			vos.add("홍성군");
			vos.add("금산군");
			vos.add("태안시");
		}
		return vos;
	}

	@Override
	public ArrayList<UserVO> getUserList(String mid) {
		return studyDAO.getUserList(mid);
	}

	@Override
	public UserVO getUserMidSearch(String mid) {
		return studyDAO.getUserMidSearch(mid);
	}

	@Override
	public ArrayList<UserVO> getUserListSearch(String mid) {
		return studyDAO.getUserListSearch(mid);
	}

}
