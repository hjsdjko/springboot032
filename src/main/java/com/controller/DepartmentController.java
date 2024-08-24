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

import com.entity.DepartmentEntity;
import com.entity.view.DepartmentView;

import com.service.DepartmentService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 院系
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-24 23:24:37
 */
@RestController
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;




    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DepartmentEntity department,
		HttpServletRequest request){
        EntityWrapper<DepartmentEntity> ew = new EntityWrapper<DepartmentEntity>();

		PageUtils page = departmentService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, department), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DepartmentEntity department, 
		HttpServletRequest request){
        EntityWrapper<DepartmentEntity> ew = new EntityWrapper<DepartmentEntity>();

		PageUtils page = departmentService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, department), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DepartmentEntity department){
       	EntityWrapper<DepartmentEntity> ew = new EntityWrapper<DepartmentEntity>();
      	ew.allEq(MPUtil.allEQMapPre( department, "department")); 
        return R.ok().put("data", departmentService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DepartmentEntity department){
        EntityWrapper< DepartmentEntity> ew = new EntityWrapper< DepartmentEntity>();
 		ew.allEq(MPUtil.allEQMapPre( department, "department")); 
		DepartmentView departmentView =  departmentService.selectView(ew);
		return R.ok("查询院系成功").put("data", departmentView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DepartmentEntity department = departmentService.selectById(id);
        return R.ok().put("data", department);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DepartmentEntity department = departmentService.selectById(id);
        return R.ok().put("data", department);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DepartmentEntity department, HttpServletRequest request){
        if(departmentService.selectCount(new EntityWrapper<DepartmentEntity>().eq("department", department.getDepartment()))>0) {
            return R.error("院系已存在");
        }
    	//ValidatorUtils.validateEntity(department);
        departmentService.insert(department);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DepartmentEntity department, HttpServletRequest request){
        if(departmentService.selectCount(new EntityWrapper<DepartmentEntity>().eq("department", department.getDepartment()))>0) {
            return R.error("院系已存在");
        }
    	//ValidatorUtils.validateEntity(department);
        departmentService.insert(department);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody DepartmentEntity department, HttpServletRequest request){
        //ValidatorUtils.validateEntity(department);
        if(departmentService.selectCount(new EntityWrapper<DepartmentEntity>().ne("id", department.getId()).eq("department", department.getDepartment()))>0) {
            return R.error("院系已存在");
        }
        departmentService.updateById(department);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        departmentService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
