package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 就业信息
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-04-24 23:24:38
 */
@TableName("employmentinformation")
public class EmploymentinformationEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public EmploymentinformationEntity() {
		
	}
	
	public EmploymentinformationEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
    @TableId(type = IdType.AUTO)
    private Long id;
	/**
	 * 学号
	 */
					
	private String studentid;
	
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
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：学号
	 */
	public void setStudentid(String studentid) {
		this.studentid = studentid;
	}
	/**
	 * 获取：学号
	 */
	public String getStudentid() {
		return studentid;
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
