package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.JobtypeEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.JobtypeVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.JobtypeView;


/**
 * 岗位类型
 *
 * @author 
 * @email 
 * @date 2024-04-24 23:24:37
 */
public interface JobtypeService extends IService<JobtypeEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JobtypeVO> selectListVO(Wrapper<JobtypeEntity> wrapper);
   	
   	JobtypeVO selectVO(@Param("ew") Wrapper<JobtypeEntity> wrapper);
   	
   	List<JobtypeView> selectListView(Wrapper<JobtypeEntity> wrapper);
   	
   	JobtypeView selectView(@Param("ew") Wrapper<JobtypeEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JobtypeEntity> wrapper);

   	

}

