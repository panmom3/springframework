package com.spring.springGroupS.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.spring.springGroupS.vo.ComplaintVO;

public interface AdminDAO {

	int setMemberLevelChange(@Param("idx") int idx, @Param("level") int level);

	int setboardComplaintInput(@Param("vo") ComplaintVO vo);

	void setBoardTableComplaintOk(@Param("partIdx") int partIdx);

	List<ComplaintVO> getComplaintList(@Param("startIndexNo") int startIndexNo, @Param("pageSize")int pageSize);

	ComplaintVO getComplaintSearch(@Param("partIdx") int partIdx);

	int setComplaintDelete(int partIdx, String part);

	int setComplaintProcess(int partIdx, String flag);

	int setComplaintProcessOk(int idx, String complaintSw);



}
