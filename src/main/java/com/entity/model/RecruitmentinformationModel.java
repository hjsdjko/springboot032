package com.entity.model;

import com.entity.RecruitmentinformationEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 招聘信息
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2024-04-24 23:24:37
 */
public class RecruitmentinformationModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 岗位名称
	 */
	
	private String jobname;
		
	/**
	 * 岗位类型
	 */
	
	private String jobtype;
		
	/**
	 * 图片
	 */
	
	private String image;
		
	/**
	 * 招聘人数
	 */
	
	private String recruitmentnumber;
		
	/**
	 * 工作时间
	 */
	
	private String workinghours;
		
	/**
	 * 专业要求
	 */
	
	private String professionalrequirements;
		
	/**
	 * 工资待遇
	 */
	
	private String salarybenefits;
		
	/**
	 * 联系电话
	 */
	
	private String contactphonenumber;
		
	/**
	 * 企业地址
	 */
	
	private String companyaddress;
		
	/**
	 * 岗位要求
	 */
	
	private String jobrequirements;
		
	/**
	 * 是否审核
	 */
	
	private String sfsh;
		
	/**
	 * 审核回复
	 */
	
	private String shhf;
		
	/**
	 * 最近点击时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date clicktime;
		
	/**
	 * 收藏数
	 */
	
	private Integer storeupnum;
				
	
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
	 * 设置：岗位类型
	 */
	 
	public void setJobtype(String jobtype) {
		this.jobtype = jobtype;
	}
	
	/**
	 * 获取：岗位类型
	 */
	public String getJobtype() {
		return jobtype;
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
	 * 设置：招聘人数
	 */
	 
	public void setRecruitmentnumber(String recruitmentnumber) {
		this.recruitmentnumber = recruitmentnumber;
	}
	
	/**
	 * 获取：招聘人数
	 */
	public String getRecruitmentnumber() {
		return recruitmentnumber;
	}
				
	
	/**
	 * 设置：工作时间
	 */
	 
	public void setWorkinghours(String workinghours) {
		this.workinghours = workinghours;
	}
	
	/**
	 * 获取：工作时间
	 */
	public String getWorkinghours() {
		return workinghours;
	}
				
	
	/**
	 * 设置：专业要求
	 */
	 
	public void setProfessionalrequirements(String professionalrequirements) {
		this.professionalrequirements = professionalrequirements;
	}
	
	/**
	 * 获取：专业要求
	 */
	public String getProfessionalrequirements() {
		return professionalrequirements;
	}
				
	
	/**
	 * 设置：工资待遇
	 */
	 
	public void setSalarybenefits(String salarybenefits) {
		this.salarybenefits = salarybenefits;
	}
	
	/**
	 * 获取：工资待遇
	 */
	public String getSalarybenefits() {
		return salarybenefits;
	}
				
	
	/**
	 * 设置：联系电话
	 */
	 
	public void setContactphonenumber(String contactphonenumber) {
		this.contactphonenumber = contactphonenumber;
	}
	
	/**
	 * 获取：联系电话
	 */
	public String getContactphonenumber() {
		return contactphonenumber;
	}
				
	
	/**
	 * 设置：企业地址
	 */
	 
	public void setCompanyaddress(String companyaddress) {
		this.companyaddress = companyaddress;
	}
	
	/**
	 * 获取：企业地址
	 */
	public String getCompanyaddress() {
		return companyaddress;
	}
				
	
	/**
	 * 设置：岗位要求
	 */
	 
	public void setJobrequirements(String jobrequirements) {
		this.jobrequirements = jobrequirements;
	}
	
	/**
	 * 获取：岗位要求
	 */
	public String getJobrequirements() {
		return jobrequirements;
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
				
	
	/**
	 * 设置：最近点击时间
	 */
	 
	public void setClicktime(Date clicktime) {
		this.clicktime = clicktime;
	}
	
	/**
	 * 获取：最近点击时间
	 */
	public Date getClicktime() {
		return clicktime;
	}
				
	
	/**
	 * 设置：收藏数
	 */
	 
	public void setStoreupnum(Integer storeupnum) {
		this.storeupnum = storeupnum;
	}
	
	/**
	 * 获取：收藏数
	 */
	public Integer getStoreupnum() {
		return storeupnum;
	}
			
}
