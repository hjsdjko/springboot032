package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.EnterpriseEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.EnterpriseVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.EnterpriseView;


/**
 * 企业
 *
 * @author 
 * @email 
 * @date 2024-04-24 23:24:37
 */
public interface EnterpriseService extends IService<EnterpriseEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<EnterpriseVO> selectListVO(Wrapper<EnterpriseEntity> wrapper);
   	
   	EnterpriseVO selectVO(@Param("ew") Wrapper<EnterpriseEntity> wrapper);
   	
   	List<EnterpriseView> selectListView(Wrapper<EnterpriseEntity> wrapper);
   	
   	EnterpriseView selectView(@Param("ew") Wrapper<EnterpriseEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<EnterpriseEntity> wrapper);

   	

}

