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
 * 企业
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-04-24 23:24:37
 */
@TableName("enterprise")
public class EnterpriseEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public EnterpriseEntity() {
		
	}
	
	public EnterpriseEntity(T t) {
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
    @TableId
    private Long id;
	/**
	 * 企业名称
	 */
					
	private String companyname;
	
	/**
	 * 密码
	 */
					
	private String password;
	
	/**
	 * 企业规模
	 */
					
	private String enterprisesize;
	
	/**
	 * 负责人
	 */
					
	private String responsibleperson;
	
	/**
	 * 性别
	 */
					
	private String gender;
	
	/**
	 * LOGO
	 */
					
	private String headportrait;
	
	/**
	 * 联系电话
	 */
					
	private String contactphonenumber;
	
	/**
	 * 邮箱
	 */
					
	private String email;
	
	/**
	 * 企业地址
	 */
					
	private String companyaddress;
	
	/**
	 * 企业介绍
	 */
					
	private String companyintroduction;
	
	
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
	 * 设置：企业规模
	 */
	public void setEnterprisesize(String enterprisesize) {
		this.enterprisesize = enterprisesize;
	}
	/**
	 * 获取：企业规模
	 */
	public String getEnterprisesize() {
		return enterprisesize;
	}
	/**
	 * 设置：负责人
	 */
	public void setResponsibleperson(String responsibleperson) {
		this.responsibleperson = responsibleperson;
	}
	/**
	 * 获取：负责人
	 */
	public String getResponsibleperson() {
		return responsibleperson;
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
	 * 设置：LOGO
	 */
	public void setHeadportrait(String headportrait) {
		this.headportrait = headportrait;
	}
	/**
	 * 获取：LOGO
	 */
	public String getHeadportrait() {
		return headportrait;
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
	 * 设置：企业介绍
	 */
	public void setCompanyintroduction(String companyintroduction) {
		this.companyintroduction = companyintroduction;
	}
	/**
	 * 获取：企业介绍
	 */
	public String getCompanyintroduction() {
		return companyintroduction;
	}

}
