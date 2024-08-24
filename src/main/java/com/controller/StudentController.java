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

import com.entity.StudentEntity;
import com.entity.view.StudentView;

import com.service.StudentService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 学生
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-24 23:24:37
 */
@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;




    
	@Autowired
	private TokenService tokenService;
	
	/**
	 * 登录
	 */
	@IgnoreAuth
	@RequestMapping(value = "/login")
	public R login(String username, String password, String captcha, HttpServletRequest request) {
		StudentEntity u = studentService.selectOne(new EntityWrapper<StudentEntity>().eq("studentid", username));
		if(u==null || !u.getPassword().equals(password)) {
			return R.error("账号或密码不正确");
		}
		
		String token = tokenService.generateToken(u.getId(), username,"student",  "student" );
		return R.ok().put("token", token);
	}


	
	/**
     * 注册
     */
	@IgnoreAuth
    @RequestMapping("/register")
    public R register(@RequestBody StudentEntity student){
    	//ValidatorUtils.validateEntity(student);
    	StudentEntity u = studentService.selectOne(new EntityWrapper<StudentEntity>().eq("studentid", student.getStudentid()));
		if(u!=null) {
			return R.error("注册用户已存在");
		}
		Long uId = new Date().getTime();
		student.setId(uId);
        studentService.insert(student);
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
        StudentEntity u = studentService.selectById(id);
        return R.ok().put("data", u);
    }
    
    /**
     * 密码重置
     */
    @IgnoreAuth
	@RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request){
    	StudentEntity u = studentService.selectOne(new EntityWrapper<StudentEntity>().eq("studentid", username));
    	if(u==null) {
    		return R.error("账号不存在");
    	}
        u.setPassword("123456");
        studentService.updateById(u);
        return R.ok("密码已重置为：123456");
    }



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,StudentEntity student,
		HttpServletRequest request){
        EntityWrapper<StudentEntity> ew = new EntityWrapper<StudentEntity>();

		PageUtils page = studentService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, student), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,StudentEntity student, 
		HttpServletRequest request){
        EntityWrapper<StudentEntity> ew = new EntityWrapper<StudentEntity>();

		PageUtils page = studentService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, student), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( StudentEntity student){
       	EntityWrapper<StudentEntity> ew = new EntityWrapper<StudentEntity>();
      	ew.allEq(MPUtil.allEQMapPre( student, "student")); 
        return R.ok().put("data", studentService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(StudentEntity student){
        EntityWrapper< StudentEntity> ew = new EntityWrapper< StudentEntity>();
 		ew.allEq(MPUtil.allEQMapPre( student, "student")); 
		StudentView studentView =  studentService.selectView(ew);
		return R.ok("查询学生成功").put("data", studentView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        StudentEntity student = studentService.selectById(id);
        return R.ok().put("data", student);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        StudentEntity student = studentService.selectById(id);
        return R.ok().put("data", student);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody StudentEntity student, HttpServletRequest request){
        if(studentService.selectCount(new EntityWrapper<StudentEntity>().eq("studentid", student.getStudentid()))>0) {
            return R.error("学号已存在");
        }
    	student.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(student);
    	StudentEntity u = studentService.selectOne(new EntityWrapper<StudentEntity>().eq("studentid", student.getStudentid()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		student.setId(new Date().getTime());
        studentService.insert(student);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody StudentEntity student, HttpServletRequest request){
        if(studentService.selectCount(new EntityWrapper<StudentEntity>().eq("studentid", student.getStudentid()))>0) {
            return R.error("学号已存在");
        }
    	student.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(student);
    	StudentEntity u = studentService.selectOne(new EntityWrapper<StudentEntity>().eq("studentid", student.getStudentid()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		student.setId(new Date().getTime());
        studentService.insert(student);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody StudentEntity student, HttpServletRequest request){
        //ValidatorUtils.validateEntity(student);
        if(studentService.selectCount(new EntityWrapper<StudentEntity>().ne("id", student.getId()).eq("studentid", student.getStudentid()))>0) {
            return R.error("学号已存在");
        }
        studentService.updateById(student);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        studentService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
