package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.InterviewinvitationEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.InterviewinvitationVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.InterviewinvitationView;


/**
 * 面试邀请
 *
 * @author 
 * @email 
 * @date 2024-04-24 23:24:38
 */
public interface InterviewinvitationService extends IService<InterviewinvitationEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<InterviewinvitationVO> selectListVO(Wrapper<InterviewinvitationEntity> wrapper);
   	
   	InterviewinvitationVO selectVO(@Param("ew") Wrapper<InterviewinvitationEntity> wrapper);
   	
   	List<InterviewinvitationView> selectListView(Wrapper<InterviewinvitationEntity> wrapper);
   	
   	InterviewinvitationView selectView(@Param("ew") Wrapper<InterviewinvitationEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<InterviewinvitationEntity> wrapper);

   	

}

