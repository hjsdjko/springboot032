package com.dao;

import com.entity.EmploymentinformationEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.EmploymentinformationVO;
import com.entity.view.EmploymentinformationView;


/**
 * 就业信息
 * 
 * @author 
 * @email 
 * @date 2024-04-24 23:24:38
 */
public interface EmploymentinformationDao extends BaseMapper<EmploymentinformationEntity> {
	
	List<EmploymentinformationVO> selectListVO(@Param("ew") Wrapper<EmploymentinformationEntity> wrapper);
	
	EmploymentinformationVO selectVO(@Param("ew") Wrapper<EmploymentinformationEntity> wrapper);
	
	List<EmploymentinformationView> selectListView(@Param("ew") Wrapper<EmploymentinformationEntity> wrapper);

	List<EmploymentinformationView> selectListView(Pagination page,@Param("ew") Wrapper<EmploymentinformationEntity> wrapper);

	
	EmploymentinformationView selectView(@Param("ew") Wrapper<EmploymentinformationEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<EmploymentinformationEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<EmploymentinformationEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<EmploymentinformationEntity> wrapper);



}
