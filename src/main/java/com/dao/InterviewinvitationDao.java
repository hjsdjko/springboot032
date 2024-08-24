package com.dao;

import com.entity.InterviewinvitationEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.InterviewinvitationVO;
import com.entity.view.InterviewinvitationView;


/**
 * 面试邀请
 * 
 * @author 
 * @email 
 * @date 2024-04-24 23:24:38
 */
public interface InterviewinvitationDao extends BaseMapper<InterviewinvitationEntity> {
	
	List<InterviewinvitationVO> selectListVO(@Param("ew") Wrapper<InterviewinvitationEntity> wrapper);
	
	InterviewinvitationVO selectVO(@Param("ew") Wrapper<InterviewinvitationEntity> wrapper);
	
	List<InterviewinvitationView> selectListView(@Param("ew") Wrapper<InterviewinvitationEntity> wrapper);

	List<InterviewinvitationView> selectListView(Pagination page,@Param("ew") Wrapper<InterviewinvitationEntity> wrapper);

	
	InterviewinvitationView selectView(@Param("ew") Wrapper<InterviewinvitationEntity> wrapper);
	

}
