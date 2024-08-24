package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.DepartmentDao;
import com.entity.DepartmentEntity;
import com.service.DepartmentService;
import com.entity.vo.DepartmentVO;
import com.entity.view.DepartmentView;

@Service("departmentService")
public class DepartmentServiceImpl extends ServiceImpl<DepartmentDao, DepartmentEntity> implements DepartmentService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DepartmentEntity> page = this.selectPage(
                new Query<DepartmentEntity>(params).getPage(),
                new EntityWrapper<DepartmentEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DepartmentEntity> wrapper) {
		  Page<DepartmentView> page =new Query<DepartmentView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<DepartmentVO> selectListVO(Wrapper<DepartmentEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DepartmentVO selectVO(Wrapper<DepartmentEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DepartmentView> selectListView(Wrapper<DepartmentEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DepartmentView selectView(Wrapper<DepartmentEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
