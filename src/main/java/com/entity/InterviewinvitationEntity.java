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
 * 面试邀请
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-04-24 23:24:38
 */
@TableName("interviewinvitation")
public class InterviewinvitationEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public InterviewinvitationEntity() {
		
	}
	
	public InterviewinvitationEntity(T t) {
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
	 * 标题
	 */
					
	private String title;
	
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
	 * 设置：标题
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * 获取：标题
	 */
	public String getTitle() {
		return title;
	}
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
