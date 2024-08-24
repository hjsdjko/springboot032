package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DepartmentEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DepartmentVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DepartmentView;


/**
 * 院系
 *
 * @author 
 * @email 
 * @date 2024-04-24 23:24:37
 */
public interface DepartmentService extends IService<DepartmentEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DepartmentVO> selectListVO(Wrapper<DepartmentEntity> wrapper);
   	
   	DepartmentVO selectVO(@Param("ew") Wrapper<DepartmentEntity> wrapper);
   	
   	List<DepartmentView> selectListView(Wrapper<DepartmentEntity> wrapper);
   	
   	DepartmentView selectView(@Param("ew") Wrapper<DepartmentEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DepartmentEntity> wrapper);

   	

}

