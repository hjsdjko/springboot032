package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.RecruitmentinformationEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.RecruitmentinformationVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.RecruitmentinformationView;


/**
 * 招聘信息
 *
 * @author 
 * @email 
 * @date 2024-04-24 23:24:37
 */
public interface RecruitmentinformationService extends IService<RecruitmentinformationEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<RecruitmentinformationVO> selectListVO(Wrapper<RecruitmentinformationEntity> wrapper);
   	
   	RecruitmentinformationVO selectVO(@Param("ew") Wrapper<RecruitmentinformationEntity> wrapper);
   	
   	List<RecruitmentinformationView> selectListView(Wrapper<RecruitmentinformationEntity> wrapper);
   	
   	RecruitmentinformationView selectView(@Param("ew") Wrapper<RecruitmentinformationEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<RecruitmentinformationEntity> wrapper);

   	

}

