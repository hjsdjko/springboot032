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


import com.dao.MajorDao;
import com.entity.MajorEntity;
import com.service.MajorService;
import com.entity.vo.MajorVO;
import com.entity.view.MajorView;

@Service("majorService")
public class MajorServiceImpl extends ServiceImpl<MajorDao, MajorEntity> implements MajorService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<MajorEntity> page = this.selectPage(
                new Query<MajorEntity>(params).getPage(),
                new EntityWrapper<MajorEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<MajorEntity> wrapper) {
		  Page<MajorView> page =new Query<MajorView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<MajorVO> selectListVO(Wrapper<MajorEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public MajorVO selectVO(Wrapper<MajorEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<MajorView> selectListView(Wrapper<MajorEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public MajorView selectView(Wrapper<MajorEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
