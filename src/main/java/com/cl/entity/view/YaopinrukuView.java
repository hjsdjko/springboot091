package com.cl.entity.view;

import com.cl.entity.YaopinrukuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 药品入库
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-04-03 11:54:38
 */
@TableName("yaopinruku")
public class YaopinrukuView  extends YaopinrukuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public YaopinrukuView(){
	}
 
 	public YaopinrukuView(YaopinrukuEntity yaopinrukuEntity){
 	try {
			BeanUtils.copyProperties(this, yaopinrukuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
