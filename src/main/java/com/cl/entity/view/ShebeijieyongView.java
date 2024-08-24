package com.cl.entity.view;

import com.cl.entity.ShebeijieyongEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 设备借用
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-04-03 11:54:38
 */
@TableName("shebeijieyong")
public class ShebeijieyongView  extends ShebeijieyongEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ShebeijieyongView(){
	}
 
 	public ShebeijieyongView(ShebeijieyongEntity shebeijieyongEntity){
 	try {
			BeanUtils.copyProperties(this, shebeijieyongEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
