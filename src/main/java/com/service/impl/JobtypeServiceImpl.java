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


import com.dao.JobtypeDao;
import com.entity.JobtypeEntity;
import com.service.JobtypeService;
import com.entity.vo.JobtypeVO;
import com.entity.view.JobtypeView;

@Service("jobtypeService")
public class JobtypeServiceImpl extends ServiceImpl<JobtypeDao, JobtypeEntity> implements JobtypeService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JobtypeEntity> page = this.selectPage(
                new Query<JobtypeEntity>(params).getPage(),
                new EntityWrapper<JobtypeEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JobtypeEntity> wrapper) {
		  Page<JobtypeView> page =new Query<JobtypeView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<JobtypeVO> selectListVO(Wrapper<JobtypeEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public JobtypeVO selectVO(Wrapper<JobtypeEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<JobtypeView> selectListView(Wrapper<JobtypeEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JobtypeView selectView(Wrapper<JobtypeEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
