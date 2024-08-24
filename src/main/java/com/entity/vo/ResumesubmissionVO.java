package com.entity.vo;

import com.entity.ResumesubmissionEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 简历投递
 * @author 
 * @email 
 * @date 2024-04-24 23:24:38
 */
public class ResumesubmissionVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 岗位名称
	 */
	
	private String jobname;
		
	/**
	 * 图片
	 */
	
	private String image;
		
	/**
	 * 学号
	 */
	
	private String studentid;
		
	/**
	 * 姓名
	 */
	
	private String name;
		
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
	 * 简历附件
	 */
	
	private String resumeattachment;
		
	/**
	 * 学历
	 */
	
	private String education;
		
	/**
	 * 个人特长
	 */
	
	private String personalstrengths;
		
	/**
	 * 工作经历
	 */
	
	private String workexperience;
				
	
	/**
	 * 设置：岗位名称
	 */
	 
	public void setJobname(String jobname) {
		this.jobname = jobname;
	}
	
	/**
	 * 获取：岗位名称
	 */
	public String getJobname() {
		return jobname;
	}
				
	
	/**
	 * 设置：图片
	 */
	 
	public void setImage(String image) {
		this.image = image;
	}
	
	/**
	 * 获取：图片
	 */
	public String getImage() {
		return image;
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
	 * 设置：简历附件
	 */
	 
	public void setResumeattachment(String resumeattachment) {
		this.resumeattachment = resumeattachment;
	}
	
	/**
	 * 获取：简历附件
	 */
	public String getResumeattachment() {
		return resumeattachment;
	}
				
	
	/**
	 * 设置：学历
	 */
	 
	public void setEducation(String education) {
		this.education = education;
	}
	
	/**
	 * 获取：学历
	 */
	public String getEducation() {
		return education;
	}
				
	
	/**
	 * 设置：个人特长
	 */
	 
	public void setPersonalstrengths(String personalstrengths) {
		this.personalstrengths = personalstrengths;
	}
	
	/**
	 * 获取：个人特长
	 */
	public String getPersonalstrengths() {
		return personalstrengths;
	}
				
	
	/**
	 * 设置：工作经历
	 */
	 
	public void setWorkexperience(String workexperience) {
		this.workexperience = workexperience;
	}
	
	/**
	 * 获取：工作经历
	 */
	public String getWorkexperience() {
		return workexperience;
	}
			
}
