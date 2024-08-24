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

import com.entity.EnterpriseEntity;
import com.entity.view.EnterpriseView;

import com.service.EnterpriseService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 企业
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-24 23:24:37
 */
@RestController
@RequestMapping("/enterprise")
public class EnterpriseController {
    @Autowired
    private EnterpriseService enterpriseService;




    
	@Autowired
	private TokenService tokenService;
	
	/**
	 * 登录
	 */
	@IgnoreAuth
	@RequestMapping(value = "/login")
	public R login(String username, String password, String captcha, HttpServletRequest request) {
		EnterpriseEntity u = enterpriseService.selectOne(new EntityWrapper<EnterpriseEntity>().eq("companyname", username));
		if(u==null || !u.getPassword().equals(password)) {
			return R.error("账号或密码不正确");
		}
		
		String token = tokenService.generateToken(u.getId(), username,"enterprise",  "enterprise" );
		return R.ok().put("token", token);
	}


	
	/**
     * 注册
     */
	@IgnoreAuth
    @RequestMapping("/register")
    public R register(@RequestBody EnterpriseEntity enterprise){
    	//ValidatorUtils.validateEntity(enterprise);
    	EnterpriseEntity u = enterpriseService.selectOne(new EntityWrapper<EnterpriseEntity>().eq("companyname", enterprise.getCompanyname()));
		if(u!=null) {
			return R.error("注册用户已存在");
		}
		Long uId = new Date().getTime();
		enterprise.setId(uId);
        enterpriseService.insert(enterprise);
        return R.ok();
    }

	
	/**
	 * 退出
	 */
	@RequestMapping("/logout")
	public R logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return R.ok("退出成功");
	}
	
	/**
     * 获取用户的session用户信息
     */
    @RequestMapping("/session")
    public R getCurrUser(HttpServletRequest request){
    	Long id = (Long)request.getSession().getAttribute("userId");
        EnterpriseEntity u = enterpriseService.selectById(id);
        return R.ok().put("data", u);
    }
    
    /**
     * 密码重置
     */
    @IgnoreAuth
	@RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request){
    	EnterpriseEntity u = enterpriseService.selectOne(new EntityWrapper<EnterpriseEntity>().eq("companyname", username));
    	if(u==null) {
    		return R.error("账号不存在");
    	}
        u.setPassword("123456");
        enterpriseService.updateById(u);
        return R.ok("密码已重置为：123456");
    }



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,EnterpriseEntity enterprise,
		HttpServletRequest request){
        EntityWrapper<EnterpriseEntity> ew = new EntityWrapper<EnterpriseEntity>();

		PageUtils page = enterpriseService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, enterprise), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,EnterpriseEntity enterprise, 
		HttpServletRequest request){
        EntityWrapper<EnterpriseEntity> ew = new EntityWrapper<EnterpriseEntity>();

		PageUtils page = enterpriseService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, enterprise), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( EnterpriseEntity enterprise){
       	EntityWrapper<EnterpriseEntity> ew = new EntityWrapper<EnterpriseEntity>();
      	ew.allEq(MPUtil.allEQMapPre( enterprise, "enterprise")); 
        return R.ok().put("data", enterpriseService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(EnterpriseEntity enterprise){
        EntityWrapper< EnterpriseEntity> ew = new EntityWrapper< EnterpriseEntity>();
 		ew.allEq(MPUtil.allEQMapPre( enterprise, "enterprise")); 
		EnterpriseView enterpriseView =  enterpriseService.selectView(ew);
		return R.ok("查询企业成功").put("data", enterpriseView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        EnterpriseEntity enterprise = enterpriseService.selectById(id);
        return R.ok().put("data", enterprise);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        EnterpriseEntity enterprise = enterpriseService.selectById(id);
        return R.ok().put("data", enterprise);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody EnterpriseEntity enterprise, HttpServletRequest request){
        if(enterpriseService.selectCount(new EntityWrapper<EnterpriseEntity>().eq("companyname", enterprise.getCompanyname()))>0) {
            return R.error("企业名称已存在");
        }
    	enterprise.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(enterprise);
    	EnterpriseEntity u = enterpriseService.selectOne(new EntityWrapper<EnterpriseEntity>().eq("companyname", enterprise.getCompanyname()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		enterprise.setId(new Date().getTime());
        enterpriseService.insert(enterprise);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody EnterpriseEntity enterprise, HttpServletRequest request){
        if(enterpriseService.selectCount(new EntityWrapper<EnterpriseEntity>().eq("companyname", enterprise.getCompanyname()))>0) {
            return R.error("企业名称已存在");
        }
    	enterprise.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(enterprise);
    	EnterpriseEntity u = enterpriseService.selectOne(new EntityWrapper<EnterpriseEntity>().eq("companyname", enterprise.getCompanyname()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		enterprise.setId(new Date().getTime());
        enterpriseService.insert(enterprise);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody EnterpriseEntity enterprise, HttpServletRequest request){
        //ValidatorUtils.validateEntity(enterprise);
        if(enterpriseService.selectCount(new EntityWrapper<EnterpriseEntity>().ne("id", enterprise.getId()).eq("companyname", enterprise.getCompanyname()))>0) {
            return R.error("企业名称已存在");
        }
        enterpriseService.updateById(enterprise);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        enterpriseService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}