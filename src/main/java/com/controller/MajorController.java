package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.MajorEntity;
import com.entity.view.MajorView;

import com.service.MajorService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 专业
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-24 23:24:37
 */
@RestController
@RequestMapping("/major")
public class MajorController {
    @Autowired
    private MajorService majorService;




    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,MajorEntity major,
		HttpServletRequest request){
        EntityWrapper<MajorEntity> ew = new EntityWrapper<MajorEntity>();

		PageUtils page = majorService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, major), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,MajorEntity major, 
		HttpServletRequest request){
        EntityWrapper<MajorEntity> ew = new EntityWrapper<MajorEntity>();

		PageUtils page = majorService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, major), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( MajorEntity major){
       	EntityWrapper<MajorEntity> ew = new EntityWrapper<MajorEntity>();
      	ew.allEq(MPUtil.allEQMapPre( major, "major")); 
        return R.ok().put("data", majorService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(MajorEntity major){
        EntityWrapper< MajorEntity> ew = new EntityWrapper< MajorEntity>();
 		ew.allEq(MPUtil.allEQMapPre( major, "major")); 
		MajorView majorView =  majorService.selectView(ew);
		return R.ok("查询专业成功").put("data", majorView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        MajorEntity major = majorService.selectById(id);
        return R.ok().put("data", major);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        MajorEntity major = majorService.selectById(id);
        return R.ok().put("data", major);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody MajorEntity major, HttpServletRequest request){
        if(majorService.selectCount(new EntityWrapper<MajorEntity>().eq("major", major.getMajor()))>0) {
            return R.error("专业已存在");
        }
    	//ValidatorUtils.validateEntity(major);
        majorService.insert(major);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody MajorEntity major, HttpServletRequest request){
        if(majorService.selectCount(new EntityWrapper<MajorEntity>().eq("major", major.getMajor()))>0) {
            return R.error("专业已存在");
        }
    	//ValidatorUtils.validateEntity(major);
        majorService.insert(major);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody MajorEntity major, HttpServletRequest request){
        //ValidatorUtils.validateEntity(major);
        if(majorService.selectCount(new EntityWrapper<MajorEntity>().ne("id", major.getId()).eq("major", major.getMajor()))>0) {
            return R.error("专业已存在");
        }
        majorService.updateById(major);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        majorService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
