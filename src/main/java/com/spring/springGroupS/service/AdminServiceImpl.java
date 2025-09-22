package com.spring.springGroupS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.springGroupS.dao.AdminDAO;
import com.spring.springGroupS.vo.BoardVO;
import com.spring.springGroupS.vo.ComplaintVO;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	AdminDAO adminDao;

	@Override
	public int setMemberLevelChange(int idx, int level) {
		
		return adminDao.setMemberLevelChange(idx, level);
	}

	@Override
	public int setmemberLevelSelectChange(String idxSelectArray, int levelSelect) {
		String[] idxSelectArrays = idxSelectArray.split("/");
		
		int res = 0;
		for(String idx : idxSelectArrays) {
			res = adminDao.setMemberLevelChange(Integer.parseInt(idx), levelSelect);
		}
		return res;
	}

	@Override
	public List<ComplaintVO> getComplaintList(int startIndexNo, int pageSize) {
		return adminDao.getComplaintList(startIndexNo, pageSize);
	}

	@Override
	public void setBoardTableComplaintOk(int partIdx) {
		adminDao.setBoardTableComplaintOk(partIdx);
	}

	@Override
	public int setBoardComplaintInput(ComplaintVO vo) {
		return adminDao.setBoardComplaintInput(vo);
	}

	@Override
	public ComplaintVO getComplaintSearch(int partIdx) {
		return adminDao.getComplaintSearch(partIdx);
	}

	@Override
	public int setComplaintDelete(int partIdx, String part) {
		return adminDao.setComplaintDelete(partIdx, part);
	}

	@Override
	public int setComplaintProcess(int partIdx, String flag) {
		return adminDao.setComplaintProcess(partIdx, flag);
	}

	@Override
	public int setComplaintProcessOk(int idx, String complaintSw) {
		return adminDao.setComplaintProcessOk(idx, complaintSw);
	}

	@Override
	public List<BoardVO> getAdBoardList() {
		return adminDao.getAdBoardList();
	}

	@Override
	public List<BoardVO> getAdGuestList() {
		return adminDao.getAdGuestList();
	}

	@Override
	public int getGuestCount() {
		return adminDao.getGuestCount();
	}

	@Override
	public int getBoardCount() {
		return adminDao.getBoardCount();
	}

	@Override
	public int getComplaintTotRecCnt(String part) {
		return adminDao.getComplaintTotRecCnt(part);
	}
}
