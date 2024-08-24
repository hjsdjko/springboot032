package com.entity.view;

import com.entity.EmploymentinformationEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 就业信息
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-04-24 23:24:38
 */
@TableName("employmentinformation")
public class EmploymentinformationView  extends EmploymentinformationEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public EmploymentinformationView(){
	}
 
 	public EmploymentinformationView(EmploymentinformationEntity employmentinformationEntity){
 	try {
			BeanUtils.copyProperties(this, employmentinformationEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
