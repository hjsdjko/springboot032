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

import com.entity.InterviewinvitationEntity;
import com.entity.view.InterviewinvitationView;

import com.service.InterviewinvitationService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 面试邀请
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-24 23:24:38
 */
@RestController
@RequestMapping("/interviewinvitation")
public class InterviewinvitationController {
    @Autowired
    private InterviewinvitationService interviewinvitationService;




    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,InterviewinvitationEntity interviewinvitation,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("enterprise")) {
			interviewinvitation.setCompanyname((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("student")) {
			interviewinvitation.setStudentid((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<InterviewinvitationEntity> ew = new EntityWrapper<InterviewinvitationEntity>();

		PageUtils page = interviewinvitationService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, interviewinvitation), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,InterviewinvitationEntity interviewinvitation, 
		HttpServletRequest request){
        EntityWrapper<InterviewinvitationEntity> ew = new EntityWrapper<InterviewinvitationEntity>();

		PageUtils page = interviewinvitationService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, interviewinvitation), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( InterviewinvitationEntity interviewinvitation){
       	EntityWrapper<InterviewinvitationEntity> ew = new EntityWrapper<InterviewinvitationEntity>();
      	ew.allEq(MPUtil.allEQMapPre( interviewinvitation, "interviewinvitation")); 
        return R.ok().put("data", interviewinvitationService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(InterviewinvitationEntity interviewinvitation){
        EntityWrapper< InterviewinvitationEntity> ew = new EntityWrapper< InterviewinvitationEntity>();
 		ew.allEq(MPUtil.allEQMapPre( interviewinvitation, "interviewinvitation")); 
		InterviewinvitationView interviewinvitationView =  interviewinvitationService.selectView(ew);
		return R.ok("查询面试邀请成功").put("data", interviewinvitationView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        InterviewinvitationEntity interviewinvitation = interviewinvitationService.selectById(id);
        return R.ok().put("data", interviewinvitation);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        InterviewinvitationEntity interviewinvitation = interviewinvitationService.selectById(id);
        return R.ok().put("data", interviewinvitation);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody InterviewinvitationEntity interviewinvitation, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(interviewinvitation);
        interviewinvitationService.insert(interviewinvitation);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody InterviewinvitationEntity interviewinvitation, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(interviewinvitation);
        interviewinvitationService.insert(interviewinvitation);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody InterviewinvitationEntity interviewinvitation, HttpServletRequest request){
        //ValidatorUtils.validateEntity(interviewinvitation);
        interviewinvitationService.updateById(interviewinvitation);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        interviewinvitationService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}