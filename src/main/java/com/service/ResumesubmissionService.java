package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ResumesubmissionEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ResumesubmissionVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ResumesubmissionView;


/**
 * 简历投递
 *
 * @author 
 * @email 
 * @date 2024-04-24 23:24:38
 */
public interface ResumesubmissionService extends IService<ResumesubmissionEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ResumesubmissionVO> selectListVO(Wrapper<ResumesubmissionEntity> wrapper);
   	
   	ResumesubmissionVO selectVO(@Param("ew") Wrapper<ResumesubmissionEntity> wrapper);
   	
   	List<ResumesubmissionView> selectListView(Wrapper<ResumesubmissionEntity> wrapper);
   	
   	ResumesubmissionView selectView(@Param("ew") Wrapper<ResumesubmissionEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ResumesubmissionEntity> wrapper);

   	

}

