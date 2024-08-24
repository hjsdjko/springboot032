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


import com.dao.InterviewinvitationDao;
import com.entity.InterviewinvitationEntity;
import com.service.InterviewinvitationService;
import com.entity.vo.InterviewinvitationVO;
import com.entity.view.InterviewinvitationView;

@Service("interviewinvitationService")
public class InterviewinvitationServiceImpl extends ServiceImpl<InterviewinvitationDao, InterviewinvitationEntity> implements InterviewinvitationService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<InterviewinvitationEntity> page = this.selectPage(
                new Query<InterviewinvitationEntity>(params).getPage(),
                new EntityWrapper<InterviewinvitationEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<InterviewinvitationEntity> wrapper) {
		  Page<InterviewinvitationView> page =new Query<InterviewinvitationView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<InterviewinvitationVO> selectListVO(Wrapper<InterviewinvitationEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public InterviewinvitationVO selectVO(Wrapper<InterviewinvitationEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<InterviewinvitationView> selectListView(Wrapper<InterviewinvitationEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public InterviewinvitationView selectView(Wrapper<InterviewinvitationEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
