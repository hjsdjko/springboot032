package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.MajorEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.MajorVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.MajorView;


/**
 * 专业
 *
 * @author 
 * @email 
 * @date 2024-04-24 23:24:37
 */
public interface MajorService extends IService<MajorEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<MajorVO> selectListVO(Wrapper<MajorEntity> wrapper);
   	
   	MajorVO selectVO(@Param("ew") Wrapper<MajorEntity> wrapper);
   	
   	List<MajorView> selectListView(Wrapper<MajorEntity> wrapper);
   	
   	MajorView selectView(@Param("ew") Wrapper<MajorEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<MajorEntity> wrapper);

   	

}

