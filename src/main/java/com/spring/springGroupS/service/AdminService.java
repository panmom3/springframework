package com.spring.springGroupS.service;

import java.util.List;

import com.spring.springGroupS.vo.ComplaintVO;

public interface AdminService {

	int setMemberLevelChange(int idx, int level);

	int setmemberLevelSelectChange(String idxSelectArray, int levelSelect);

	int setboardComplaintInput(ComplaintVO vo);

	void setBoardTableComplaintOk(int partIdx);

	List<ComplaintVO> getComplaintList(int startIndexNo, int pageSize);

	ComplaintVO getComplaintSearch(int partIdx);

	int setComplaintDelete(int partIdx, String part);

	int setComplaintProcess(int partIdx, String flag);

	int setComplaintProcessOk(int idx, String complaintSw);



}
