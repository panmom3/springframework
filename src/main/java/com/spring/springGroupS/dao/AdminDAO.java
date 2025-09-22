package com.spring.springGroupS.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.spring.springGroupS.vo.BoardVO;
import com.spring.springGroupS.vo.ComplaintVO;

public interface AdminDAO {

	int setMemberLevelChange(@Param("idx") int idx, @Param("level") int level);

	List<ComplaintVO> getComplaintList(@Param("startIndexNo") int startIndexNo, @Param("pageSize") int pageSize);

	void setBoardTableComplaintOk(@Param("partIdx") int partIdx);

	int setBoardComplaintInput(@Param("vo") ComplaintVO vo);

	ComplaintVO getComplaintSearch(@Param("partIdx") int partIdx);

	int setComplaintDelete(@Param("partIdx") int partIdx, @Param("part") String part);

	int setComplaintProcess(@Param("partIdx")int partIdx, @Param("flag") String flag);

	int setComplaintProcessOk(@Param("idx")int idx, @Param("complaintSw")String complaintSw);

	List<BoardVO> getAdBoardList();

	List<BoardVO> getAdGuestList();

	int getGuestCount();

	int getBoardCount();

	int getComplaintTotRecCnt(@Param("part") String part);


}
