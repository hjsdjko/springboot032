package com.entity.model;

import com.entity.EmploymentinformationEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 就业信息
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2024-04-24 23:24:38
 */
public class EmploymentinformationModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 姓名
	 */
	
	private String name;
		
	/**
	 * 专业
	 */
	
	private String major;
		
	/**
	 * 院系
	 */
	
	private String department;
		
	/**
	 * 头像
	 */
	
	private String headportrait;
		
	/**
	 * 性别
	 */
	
	private String gender;
		
	/**
	 * 就业公司
	 */
	
	private String employmentcompany;
		
	/**
	 * 从事行业
	 */
	
	private String industry;
		
	/**
	 * 工作省份
	 */
	
	private String workprovince;
		
	/**
	 * 就业月份
	 */
	
	private String employmentmonth;
		
	/**
	 * 薪资
	 */
	
	private Double salary;
		
	/**
	 * 就业情况
	 */
	
	private String employmentsituation;
		
	/**
	 * 是否审核
	 */
	
	private String sfsh;
		
	/**
	 * 审核回复
	 */
	
	private String shhf;
				
	
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
	 * 设置：就业公司
	 */
	 
	public void setEmploymentcompany(String employmentcompany) {
		this.employmentcompany = employmentcompany;
	}
	
	/**
	 * 获取：就业公司
	 */
	public String getEmploymentcompany() {
		return employmentcompany;
	}
				
	
	/**
	 * 设置：从事行业
	 */
	 
	public void setIndustry(String industry) {
		this.industry = industry;
	}
	
	/**
	 * 获取：从事行业
	 */
	public String getIndustry() {
		return industry;
	}
				
	
	/**
	 * 设置：工作省份
	 */
	 
	public void setWorkprovince(String workprovince) {
		this.workprovince = workprovince;
	}
	
	/**
	 * 获取：工作省份
	 */
	public String getWorkprovince() {
		return workprovince;
	}
				
	
	/**
	 * 设置：就业月份
	 */
	 
	public void setEmploymentmonth(String employmentmonth) {
		this.employmentmonth = employmentmonth;
	}
	
	/**
	 * 获取：就业月份
	 */
	public String getEmploymentmonth() {
		return employmentmonth;
	}
				
	
	/**
	 * 设置：薪资
	 */
	 
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	
	/**
	 * 获取：薪资
	 */
	public Double getSalary() {
		return salary;
	}
				
	
	/**
	 * 设置：就业情况
	 */
	 
	public void setEmploymentsituation(String employmentsituation) {
		this.employmentsituation = employmentsituation;
	}
	
	/**
	 * 获取：就业情况
	 */
	public String getEmploymentsituation() {
		return employmentsituation;
	}
				
	
	/**
	 * 设置：是否审核
	 */
	 
	public void setSfsh(String sfsh) {
		this.sfsh = sfsh;
	}
	
	/**
	 * 获取：是否审核
	 */
	public String getSfsh() {
		return sfsh;
	}
				
	
	/**
	 * 设置：审核回复
	 */
	 
	public void setShhf(String shhf) {
		this.shhf = shhf;
	}
	
	/**
	 * 获取：审核回复
	 */
	public String getShhf() {
		return shhf;
	}
			
}
