package com.entity.view;

import com.entity.EnterpriseEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 企业
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-04-24 23:24:37
 */
@TableName("enterprise")
public class EnterpriseView  extends EnterpriseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public EnterpriseView(){
	}
 
 	public EnterpriseView(EnterpriseEntity enterpriseEntity){
 	try {
			BeanUtils.copyProperties(this, enterpriseEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
