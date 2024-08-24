package com.dao;

import com.entity.ResumesubmissionEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ResumesubmissionVO;
import com.entity.view.ResumesubmissionView;


/**
 * 简历投递
 * 
 * @author 
 * @email 
 * @date 2024-04-24 23:24:38
 */
public interface ResumesubmissionDao extends BaseMapper<ResumesubmissionEntity> {
	
	List<ResumesubmissionVO> selectListVO(@Param("ew") Wrapper<ResumesubmissionEntity> wrapper);
	
	ResumesubmissionVO selectVO(@Param("ew") Wrapper<ResumesubmissionEntity> wrapper);
	
	List<ResumesubmissionView> selectListView(@Param("ew") Wrapper<ResumesubmissionEntity> wrapper);

	List<ResumesubmissionView> selectListView(Pagination page,@Param("ew") Wrapper<ResumesubmissionEntity> wrapper);

	
	ResumesubmissionView selectView(@Param("ew") Wrapper<ResumesubmissionEntity> wrapper);
	

}
