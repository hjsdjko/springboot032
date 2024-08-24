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


import com.dao.ResumesubmissionDao;
import com.entity.ResumesubmissionEntity;
import com.service.ResumesubmissionService;
import com.entity.vo.ResumesubmissionVO;
import com.entity.view.ResumesubmissionView;

@Service("resumesubmissionService")
public class ResumesubmissionServiceImpl extends ServiceImpl<ResumesubmissionDao, ResumesubmissionEntity> implements ResumesubmissionService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ResumesubmissionEntity> page = this.selectPage(
                new Query<ResumesubmissionEntity>(params).getPage(),
                new EntityWrapper<ResumesubmissionEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ResumesubmissionEntity> wrapper) {
		  Page<ResumesubmissionView> page =new Query<ResumesubmissionView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<ResumesubmissionVO> selectListVO(Wrapper<ResumesubmissionEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ResumesubmissionVO selectVO(Wrapper<ResumesubmissionEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ResumesubmissionView> selectListView(Wrapper<ResumesubmissionEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ResumesubmissionView selectView(Wrapper<ResumesubmissionEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
