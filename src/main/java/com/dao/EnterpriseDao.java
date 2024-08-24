package com.dao;

import com.entity.EnterpriseEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.EnterpriseVO;
import com.entity.view.EnterpriseView;


/**
 * 企业
 * 
 * @author 
 * @email 
 * @date 2024-04-24 23:24:37
 */
public interface EnterpriseDao extends BaseMapper<EnterpriseEntity> {
	
	List<EnterpriseVO> selectListVO(@Param("ew") Wrapper<EnterpriseEntity> wrapper);
	
	EnterpriseVO selectVO(@Param("ew") Wrapper<EnterpriseEntity> wrapper);
	
	List<EnterpriseView> selectListView(@Param("ew") Wrapper<EnterpriseEntity> wrapper);

	List<EnterpriseView> selectListView(Pagination page,@Param("ew") Wrapper<EnterpriseEntity> wrapper);

	
	EnterpriseView selectView(@Param("ew") Wrapper<EnterpriseEntity> wrapper);
	

}
