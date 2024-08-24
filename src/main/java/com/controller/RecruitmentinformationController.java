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

import com.entity.RecruitmentinformationEntity;
import com.entity.view.RecruitmentinformationView;

import com.service.RecruitmentinformationService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;
import com.service.StoreupService;
import com.entity.StoreupEntity;

/**
 * 招聘信息
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-24 23:24:37
 */
@RestController
@RequestMapping("/recruitmentinformation")
public class RecruitmentinformationController {
    @Autowired
    private RecruitmentinformationService recruitmentinformationService;

    @Autowired
    private StoreupService storeupService;



    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,RecruitmentinformationEntity recruitmentinformation,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("enterprise")) {
			recruitmentinformation.setCompanyname((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<RecruitmentinformationEntity> ew = new EntityWrapper<RecruitmentinformationEntity>();

		PageUtils page = recruitmentinformationService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, recruitmentinformation), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,RecruitmentinformationEntity recruitmentinformation, 
		HttpServletRequest request){
        EntityWrapper<RecruitmentinformationEntity> ew = new EntityWrapper<RecruitmentinformationEntity>();

		PageUtils page = recruitmentinformationService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, recruitmentinformation), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( RecruitmentinformationEntity recruitmentinformation){
       	EntityWrapper<RecruitmentinformationEntity> ew = new EntityWrapper<RecruitmentinformationEntity>();
      	ew.allEq(MPUtil.allEQMapPre( recruitmentinformation, "recruitmentinformation")); 
        return R.ok().put("data", recruitmentinformationService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(RecruitmentinformationEntity recruitmentinformation){
        EntityWrapper< RecruitmentinformationEntity> ew = new EntityWrapper< RecruitmentinformationEntity>();
 		ew.allEq(MPUtil.allEQMapPre( recruitmentinformation, "recruitmentinformation")); 
		RecruitmentinformationView recruitmentinformationView =  recruitmentinformationService.selectView(ew);
		return R.ok("查询招聘信息成功").put("data", recruitmentinformationView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        RecruitmentinformationEntity recruitmentinformation = recruitmentinformationService.selectById(id);
		recruitmentinformation.setClicktime(new Date());
		recruitmentinformationService.updateById(recruitmentinformation);
        recruitmentinformation = recruitmentinformationService.selectView(new EntityWrapper<RecruitmentinformationEntity>().eq("id", id));
        return R.ok().put("data", recruitmentinformation);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        RecruitmentinformationEntity recruitmentinformation = recruitmentinformationService.selectById(id);
		recruitmentinformation.setClicktime(new Date());
		recruitmentinformationService.updateById(recruitmentinformation);
        recruitmentinformation = recruitmentinformationService.selectView(new EntityWrapper<RecruitmentinformationEntity>().eq("id", id));
        return R.ok().put("data", recruitmentinformation);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody RecruitmentinformationEntity recruitmentinformation, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(recruitmentinformation);
        recruitmentinformationService.insert(recruitmentinformation);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody RecruitmentinformationEntity recruitmentinformation, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(recruitmentinformation);
        recruitmentinformationService.insert(recruitmentinformation);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody RecruitmentinformationEntity recruitmentinformation, HttpServletRequest request){
        //ValidatorUtils.validateEntity(recruitmentinformation);
        recruitmentinformationService.updateById(recruitmentinformation);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<RecruitmentinformationEntity> list = new ArrayList<RecruitmentinformationEntity>();
        for(Long id : ids) {
            RecruitmentinformationEntity recruitmentinformation = recruitmentinformationService.selectById(id);
            recruitmentinformation.setSfsh(sfsh);
            recruitmentinformation.setShhf(shhf);
            list.add(recruitmentinformation);
        }
        recruitmentinformationService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        recruitmentinformationService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前台智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,RecruitmentinformationEntity recruitmentinformation, HttpServletRequest request,String pre){
        EntityWrapper<RecruitmentinformationEntity> ew = new EntityWrapper<RecruitmentinformationEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicktime");
        params.put("order", "desc");
		PageUtils page = recruitmentinformationService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, recruitmentinformation), params), params));
        return R.ok().put("data", page);
    }


    /**
     * 协同算法（按收藏推荐）
     */
    @RequestMapping("/autoSort2")
    public R autoSort2(@RequestParam Map<String, Object> params,RecruitmentinformationEntity recruitmentinformation, HttpServletRequest request){
        String userId = request.getSession().getAttribute("userId").toString();
        String inteltypeColumn = "jobtype";
        List<StoreupEntity> storeups = storeupService.selectList(new EntityWrapper<StoreupEntity>().eq("type", 1).eq("userid", userId).eq("tablename", "recruitmentinformation").orderBy("addtime", false));
        List<String> inteltypes = new ArrayList<String>();
        Integer limit = params.get("limit")==null?10:Integer.parseInt(params.get("limit").toString());
        List<RecruitmentinformationEntity> recruitmentinformationList = new ArrayList<RecruitmentinformationEntity>();
        //去重
        if(storeups!=null && storeups.size()>0) {
            for(StoreupEntity s : storeups) {
                recruitmentinformationList.addAll(recruitmentinformationService.selectList(new EntityWrapper<RecruitmentinformationEntity>().eq(inteltypeColumn, s.getInteltype())));
            }
        }
        EntityWrapper<RecruitmentinformationEntity> ew = new EntityWrapper<RecruitmentinformationEntity>();
        params.put("sort", "id");
        params.put("order", "desc");
        PageUtils page = recruitmentinformationService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, recruitmentinformation), params), params));
        List<RecruitmentinformationEntity> pageList = (List<RecruitmentinformationEntity>)page.getList();
        if(recruitmentinformationList.size()<limit) {
            int toAddNum = (limit-recruitmentinformationList.size())<=pageList.size()?(limit-recruitmentinformationList.size()):pageList.size();
            for(RecruitmentinformationEntity o1 : pageList) {
                boolean addFlag = true;
                for(RecruitmentinformationEntity o2 : recruitmentinformationList) {
                    if(o1.getId().intValue()==o2.getId().intValue()) {
                        addFlag = false;
                        break;
                    }
                }
                if(addFlag) {
                    recruitmentinformationList.add(o1);
                    if(--toAddNum==0) break;
                }
            }
        } else if(recruitmentinformationList.size()>limit) {
            recruitmentinformationList = recruitmentinformationList.subList(0, limit);
        }
        page.setList(recruitmentinformationList);
        return R.ok().put("data", page);
    }








}
