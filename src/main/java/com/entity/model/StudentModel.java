package com.entity.model;

import com.entity.StudentEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 学生
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2024-04-24 23:24:37
 */
public class StudentModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 密码
	 */
	
	private String password;
		
	/**
	 * 姓名
	 */
	
	private String name;
		
	/**
	 * 头像
	 */
	
	private String headportrait;
		
	/**
	 * 性别
	 */
	
	private String gender;
		
	/**
	 * 年龄
	 */
	
	private Integer age;
		
	/**
	 * 院系
	 */
	
	private String department;
		
	/**
	 * 专业
	 */
	
	private String major;
		
	/**
	 * 手机
	 */
	
	private String mobilephone;
		
	/**
	 * 邮箱
	 */
	
	private String email;
				
	
	/**
	 * 设置：密码
	 */
	 
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * 获取：密码
	 */
	public String getPassword() {
		return password;
	}
				
	
	/**
	 * 设置：姓名
	 */
	 
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * 获取：姓名
	 */
	public String getName() {
		return name;
	}
				
	
	/**
	 * 设置：头像
	 */
	 
	public void setHeadportrait(String headportrait) {
		this.headportrait = headportrait;
	}
	
	/**
	 * 获取：头像
	 */
	public String getHeadportrait() {
		return headportrait;
	}
				
	
	/**
	 * 设置：性别
	 */
	 
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	/**
	 * 获取：性别
	 */
	public String getGender() {
		return gender;
	}
				
	
	/**
	 * 设置：年龄
	 */
	 
	public void setAge(Integer age) {
		this.age = age;
	}
	
	/**
	 * 获取：年龄
	 */
	public Integer getAge() {
		return age;
	}
				
	
	/**
	 * 设置：院系
	 */
	 
	public void setDepartment(String department) {
		this.department = department;
	}
	
	/**
	 * 获取：院系
	 */
	public String getDepartment() {
		return department;
	}
				
	
	/**
	 * 设置：专业
	 */
	 
	public void setMajor(String major) {
		this.major = major;
	}
	
	/**
	 * 获取：专业
	 */
	public String getMajor() {
		return major;
	}
				
	
	/**
	 * 设置：手机
	 */
	 
	public void setMobilephone(String mobilephone) {
		this.mobilephone = mobilephone;
	}
	
	/**
	 * 获取：手机
	 */
	public String getMobilephone() {
		return mobilephone;
	}
				
	
	/**
	 * 设置：邮箱
	 */
	 
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * 获取：邮箱
	 */
	public String getEmail() {
		return email;
	}
			
}
