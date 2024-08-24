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

import com.entity.ResumesubmissionEntity;
import com.entity.view.ResumesubmissionView;

import com.service.ResumesubmissionService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 简历投递
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-24 23:24:38
 */
@RestController
@RequestMapping("/resumesubmission")
public class ResumesubmissionController {
    @Autowired
    private ResumesubmissionService resumesubmissionService;




    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ResumesubmissionEntity resumesubmission,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("enterprise")) {
			resumesubmission.setCompanyname((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("student")) {
			resumesubmission.setStudentid((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ResumesubmissionEntity> ew = new EntityWrapper<ResumesubmissionEntity>();

		PageUtils page = resumesubmissionService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, resumesubmission), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ResumesubmissionEntity resumesubmission, 
		HttpServletRequest request){
        EntityWrapper<ResumesubmissionEntity> ew = new EntityWrapper<ResumesubmissionEntity>();

		PageUtils page = resumesubmissionService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, resumesubmission), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ResumesubmissionEntity resumesubmission){
       	EntityWrapper<ResumesubmissionEntity> ew = new EntityWrapper<ResumesubmissionEntity>();
      	ew.allEq(MPUtil.allEQMapPre( resumesubmission, "resumesubmission")); 
        return R.ok().put("data", resumesubmissionService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ResumesubmissionEntity resumesubmission){
        EntityWrapper< ResumesubmissionEntity> ew = new EntityWrapper< ResumesubmissionEntity>();
 		ew.allEq(MPUtil.allEQMapPre( resumesubmission, "resumesubmission")); 
		ResumesubmissionView resumesubmissionView =  resumesubmissionService.selectView(ew);
		return R.ok("查询简历投递成功").put("data", resumesubmissionView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ResumesubmissionEntity resumesubmission = resumesubmissionService.selectById(id);
        return R.ok().put("data", resumesubmission);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ResumesubmissionEntity resumesubmission = resumesubmissionService.selectById(id);
        return R.ok().put("data", resumesubmission);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ResumesubmissionEntity resumesubmission, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(resumesubmission);
        resumesubmissionService.insert(resumesubmission);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ResumesubmissionEntity resumesubmission, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(resumesubmission);
        resumesubmissionService.insert(resumesubmission);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ResumesubmissionEntity resumesubmission, HttpServletRequest request){
        //ValidatorUtils.validateEntity(resumesubmission);
        resumesubmissionService.updateById(resumesubmission);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        resumesubmissionService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
