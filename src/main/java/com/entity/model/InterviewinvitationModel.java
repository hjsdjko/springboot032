package com.entity.model;

import com.entity.InterviewinvitationEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 面试邀请
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2024-04-24 23:24:38
 */
public class InterviewinvitationModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 企业名称
	 */
	
	private String companyname;
		
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
	 * 面试时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date interviewtime;
		
	/**
	 * 面试地点
	 */
	
	private String interviewlocation;
		
	/**
	 * 邀请说明
	 */
	
	private String invitationdescription;
		
	/**
	 * 回复内容
	 */
	
	private String shhf;
				
	
	/**
	 * 设置：企业名称
	 */
	 
	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}
	
	/**
	 * 获取：企业名称
	 */
	public String getCompanyname() {
		return companyname;
	}
				
	
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
	 * 设置：面试时间
	 */
	 
	public void setInterviewtime(Date interviewtime) {
		this.interviewtime = interviewtime;
	}
	
	/**
	 * 获取：面试时间
	 */
	public Date getInterviewtime() {
		return interviewtime;
	}
				
	
	/**
	 * 设置：面试地点
	 */
	 
	public void setInterviewlocation(String interviewlocation) {
		this.interviewlocation = interviewlocation;
	}
	
	/**
	 * 获取：面试地点
	 */
	public String getInterviewlocation() {
		return interviewlocation;
	}
				
	
	/**
	 * 设置：邀请说明
	 */
	 
	public void setInvitationdescription(String invitationdescription) {
		this.invitationdescription = invitationdescription;
	}
	
	/**
	 * 获取：邀请说明
	 */
	public String getInvitationdescription() {
		return invitationdescription;
	}
				
	
	/**
	 * 设置：回复内容
	 */
	 
	public void setShhf(String shhf) {
		this.shhf = shhf;
	}
	
	/**
	 * 获取：回复内容
	 */
	public String getShhf() {
		return shhf;
	}
			
}
