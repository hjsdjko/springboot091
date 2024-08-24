package com.cl.entity.view;

import com.cl.entity.ShijiyaopinEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 试剂药品
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-04-03 11:54:38
 */
@TableName("shijiyaopin")
public class ShijiyaopinView  extends ShijiyaopinEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ShijiyaopinView(){
	}
 
 	public ShijiyaopinView(ShijiyaopinEntity shijiyaopinEntity){
 	try {
			BeanUtils.copyProperties(this, shijiyaopinEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
