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


import com.dao.EnterpriseDao;
import com.entity.EnterpriseEntity;
import com.service.EnterpriseService;
import com.entity.vo.EnterpriseVO;
import com.entity.view.EnterpriseView;

@Service("enterpriseService")
public class EnterpriseServiceImpl extends ServiceImpl<EnterpriseDao, EnterpriseEntity> implements EnterpriseService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<EnterpriseEntity> page = this.selectPage(
                new Query<EnterpriseEntity>(params).getPage(),
                new EntityWrapper<EnterpriseEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<EnterpriseEntity> wrapper) {
		  Page<EnterpriseView> page =new Query<EnterpriseView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<EnterpriseVO> selectListVO(Wrapper<EnterpriseEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public EnterpriseVO selectVO(Wrapper<EnterpriseEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<EnterpriseView> selectListView(Wrapper<EnterpriseEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public EnterpriseView selectView(Wrapper<EnterpriseEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
