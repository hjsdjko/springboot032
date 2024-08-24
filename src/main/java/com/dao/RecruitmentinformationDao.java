package com.dao;

import com.entity.RecruitmentinformationEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.RecruitmentinformationVO;
import com.entity.view.RecruitmentinformationView;


/**
 * 招聘信息
 * 
 * @author 
 * @email 
 * @date 2024-04-24 23:24:37
 */
public interface RecruitmentinformationDao extends BaseMapper<RecruitmentinformationEntity> {
	
	List<RecruitmentinformationVO> selectListVO(@Param("ew") Wrapper<RecruitmentinformationEntity> wrapper);
	
	RecruitmentinformationVO selectVO(@Param("ew") Wrapper<RecruitmentinformationEntity> wrapper);
	
	List<RecruitmentinformationView> selectListView(@Param("ew") Wrapper<RecruitmentinformationEntity> wrapper);

	List<RecruitmentinformationView> selectListView(Pagination page,@Param("ew") Wrapper<RecruitmentinformationEntity> wrapper);

	
	RecruitmentinformationView selectView(@Param("ew") Wrapper<RecruitmentinformationEntity> wrapper);
	

}
