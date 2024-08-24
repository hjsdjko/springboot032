package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.EmploymentinformationEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.EmploymentinformationVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.EmploymentinformationView;


/**
 * 就业信息
 *
 * @author 
 * @email 
 * @date 2024-04-24 23:24:38
 */
public interface EmploymentinformationService extends IService<EmploymentinformationEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<EmploymentinformationVO> selectListVO(Wrapper<EmploymentinformationEntity> wrapper);
   	
   	EmploymentinformationVO selectVO(@Param("ew") Wrapper<EmploymentinformationEntity> wrapper);
   	
   	List<EmploymentinformationView> selectListView(Wrapper<EmploymentinformationEntity> wrapper);
   	
   	EmploymentinformationView selectView(@Param("ew") Wrapper<EmploymentinformationEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<EmploymentinformationEntity> wrapper);

   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<EmploymentinformationEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<EmploymentinformationEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<EmploymentinformationEntity> wrapper);



}

