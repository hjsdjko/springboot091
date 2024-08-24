package com.cl.entity.view;

import com.cl.entity.ShiyankechengEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 实验课程
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-04-03 11:54:38
 */
@TableName("shiyankecheng")
public class ShiyankechengView  extends ShiyankechengEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ShiyankechengView(){
	}
 
 	public ShiyankechengView(ShiyankechengEntity shiyankechengEntity){
 	try {
			BeanUtils.copyProperties(this, shiyankechengEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
