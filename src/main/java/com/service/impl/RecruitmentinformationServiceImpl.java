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


import com.dao.RecruitmentinformationDao;
import com.entity.RecruitmentinformationEntity;
import com.service.RecruitmentinformationService;
import com.entity.vo.RecruitmentinformationVO;
import com.entity.view.RecruitmentinformationView;

@Service("recruitmentinformationService")
public class RecruitmentinformationServiceImpl extends ServiceImpl<RecruitmentinformationDao, RecruitmentinformationEntity> implements RecruitmentinformationService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<RecruitmentinformationEntity> page = this.selectPage(
                new Query<RecruitmentinformationEntity>(params).getPage(),
                new EntityWrapper<RecruitmentinformationEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<RecruitmentinformationEntity> wrapper) {
		  Page<RecruitmentinformationView> page =new Query<RecruitmentinformationView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<RecruitmentinformationVO> selectListVO(Wrapper<RecruitmentinformationEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public RecruitmentinformationVO selectVO(Wrapper<RecruitmentinformationEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<RecruitmentinformationView> selectListView(Wrapper<RecruitmentinformationEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public RecruitmentinformationView selectView(Wrapper<RecruitmentinformationEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
