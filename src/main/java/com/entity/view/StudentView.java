package com.entity.view;

import com.entity.StudentEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 学生
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-04-24 23:24:37
 */
@TableName("student")
public class StudentView  extends StudentEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public StudentView(){
	}
 
 	public StudentView(StudentEntity studentEntity){
 	try {
			BeanUtils.copyProperties(this, studentEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}