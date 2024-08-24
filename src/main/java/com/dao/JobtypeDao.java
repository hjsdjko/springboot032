package com.dao;

import com.entity.JobtypeEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.JobtypeVO;
import com.entity.view.JobtypeView;


/**
 * 岗位类型
 * 
 * @author 
 * @email 
 * @date 2024-04-24 23:24:37
 */
public interface JobtypeDao extends BaseMapper<JobtypeEntity> {
	
	List<JobtypeVO> selectListVO(@Param("ew") Wrapper<JobtypeEntity> wrapper);
	
	JobtypeVO selectVO(@Param("ew") Wrapper<JobtypeEntity> wrapper);
	
	List<JobtypeView> selectListView(@Param("ew") Wrapper<JobtypeEntity> wrapper);

	List<JobtypeView> selectListView(Pagination page,@Param("ew") Wrapper<JobtypeEntity> wrapper);

	
	JobtypeView selectView(@Param("ew") Wrapper<JobtypeEntity> wrapper);
	

}
