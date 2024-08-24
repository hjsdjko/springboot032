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


import com.dao.EmploymentinformationDao;
import com.entity.EmploymentinformationEntity;
import com.service.EmploymentinformationService;
import com.entity.vo.EmploymentinformationVO;
import com.entity.view.EmploymentinformationView;

@Service("employmentinformationService")
public class EmploymentinformationServiceImpl extends ServiceImpl<EmploymentinformationDao, EmploymentinformationEntity> implements EmploymentinformationService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<EmploymentinformationEntity> page = this.selectPage(
                new Query<EmploymentinformationEntity>(params).getPage(),
                new EntityWrapper<EmploymentinformationEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<EmploymentinformationEntity> wrapper) {
		  Page<EmploymentinformationView> page =new Query<EmploymentinformationView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<EmploymentinformationVO> selectListVO(Wrapper<EmploymentinformationEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public EmploymentinformationVO selectVO(Wrapper<EmploymentinformationEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<EmploymentinformationView> selectListView(Wrapper<EmploymentinformationEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public EmploymentinformationView selectView(Wrapper<EmploymentinformationEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<EmploymentinformationEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<EmploymentinformationEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<EmploymentinformationEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }




}
