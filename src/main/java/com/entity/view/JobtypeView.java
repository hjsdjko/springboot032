package com.entity.view;

import com.entity.JobtypeEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 岗位类型
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-04-24 23:24:37
 */
@TableName("jobtype")
public class JobtypeView  extends JobtypeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public JobtypeView(){
	}
 
 	public JobtypeView(JobtypeEntity jobtypeEntity){
 	try {
			BeanUtils.copyProperties(this, jobtypeEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
