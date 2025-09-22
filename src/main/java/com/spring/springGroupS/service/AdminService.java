package com.spring.springGroupS.service;

import java.util.List;

import com.spring.springGroupS.vo.BoardVO;
import com.spring.springGroupS.vo.ComplaintVO;

public interface AdminService {

	int setMemberLevelChange(int idx, int level);

	int setmemberLevelSelectChange(String idxSelectArray, int levelSelect);

	List<ComplaintVO> getComplaintList(int startIndexNo, int pageSize);

	void setBoardTableComplaintOk(int partIdx);

	int setBoardComplaintInput(ComplaintVO vo);

	ComplaintVO getComplaintSearch(int partIdx);

	int setComplaintDelete(int partIdx, String part);

	int setComplaintProcess(int partIdx, String flag);

	int setComplaintProcessOk(int idx, String complaintSw);

	List<BoardVO> getAdBoardList();

	List<BoardVO> getAdGuestList();

	int getGuestCount();

	int getBoardCount();
	
	int getComplaintTotRecCnt(String part);

}
