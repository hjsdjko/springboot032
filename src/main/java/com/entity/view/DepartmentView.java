package com.entity.view;

import com.entity.DepartmentEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 院系
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-04-24 23:24:37
 */
@TableName("department")
public class DepartmentView  extends DepartmentEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DepartmentView(){
	}
 
 	public DepartmentView(DepartmentEntity departmentEntity){
 	try {
			BeanUtils.copyProperties(this, departmentEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
