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

import com.entity.JobtypeEntity;
import com.entity.view.JobtypeView;

import com.service.JobtypeService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 岗位类型
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-24 23:24:37
 */
@RestController
@RequestMapping("/jobtype")
public class JobtypeController {
    @Autowired
    private JobtypeService jobtypeService;




    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JobtypeEntity jobtype,
		HttpServletRequest request){
        EntityWrapper<JobtypeEntity> ew = new EntityWrapper<JobtypeEntity>();

		PageUtils page = jobtypeService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jobtype), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,JobtypeEntity jobtype, 
		HttpServletRequest request){
        EntityWrapper<JobtypeEntity> ew = new EntityWrapper<JobtypeEntity>();

		PageUtils page = jobtypeService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jobtype), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JobtypeEntity jobtype){
       	EntityWrapper<JobtypeEntity> ew = new EntityWrapper<JobtypeEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jobtype, "jobtype")); 
        return R.ok().put("data", jobtypeService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JobtypeEntity jobtype){
        EntityWrapper< JobtypeEntity> ew = new EntityWrapper< JobtypeEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jobtype, "jobtype")); 
		JobtypeView jobtypeView =  jobtypeService.selectView(ew);
		return R.ok("查询岗位类型成功").put("data", jobtypeView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JobtypeEntity jobtype = jobtypeService.selectById(id);
        return R.ok().put("data", jobtype);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JobtypeEntity jobtype = jobtypeService.selectById(id);
        return R.ok().put("data", jobtype);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JobtypeEntity jobtype, HttpServletRequest request){
        if(jobtypeService.selectCount(new EntityWrapper<JobtypeEntity>().eq("jobtype", jobtype.getJobtype()))>0) {
            return R.error("岗位类型已存在");
        }
    	//ValidatorUtils.validateEntity(jobtype);
        jobtypeService.insert(jobtype);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JobtypeEntity jobtype, HttpServletRequest request){
        if(jobtypeService.selectCount(new EntityWrapper<JobtypeEntity>().eq("jobtype", jobtype.getJobtype()))>0) {
            return R.error("岗位类型已存在");
        }
    	//ValidatorUtils.validateEntity(jobtype);
        jobtypeService.insert(jobtype);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody JobtypeEntity jobtype, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jobtype);
        if(jobtypeService.selectCount(new EntityWrapper<JobtypeEntity>().ne("id", jobtype.getId()).eq("jobtype", jobtype.getJobtype()))>0) {
            return R.error("岗位类型已存在");
        }
        jobtypeService.updateById(jobtype);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jobtypeService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
