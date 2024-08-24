package com.dao;

import com.entity.MajorEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.MajorVO;
import com.entity.view.MajorView;


/**
 * 专业
 * 
 * @author 
 * @email 
 * @date 2024-04-24 23:24:37
 */
public interface MajorDao extends BaseMapper<MajorEntity> {
	
	List<MajorVO> selectListVO(@Param("ew") Wrapper<MajorEntity> wrapper);
	
	MajorVO selectVO(@Param("ew") Wrapper<MajorEntity> wrapper);
	
	List<MajorView> selectListView(@Param("ew") Wrapper<MajorEntity> wrapper);

	List<MajorView> selectListView(Pagination page,@Param("ew") Wrapper<MajorEntity> wrapper);

	
	MajorView selectView(@Param("ew") Wrapper<MajorEntity> wrapper);
	

}
