package com.cl.entity.view;

import com.cl.entity.ShiyanshileixingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 实验室类型
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-04-03 11:54:37
 */
@TableName("shiyanshileixing")
public class ShiyanshileixingView  extends ShiyanshileixingEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ShiyanshileixingView(){
	}
 
 	public ShiyanshileixingView(ShiyanshileixingEntity shiyanshileixingEntity){
 	try {
			BeanUtils.copyProperties(this, shiyanshileixingEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
