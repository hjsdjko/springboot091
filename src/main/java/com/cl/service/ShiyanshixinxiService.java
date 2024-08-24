package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.ShiyanshixinxiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ShiyanshixinxiView;


/**
 * 实验室信息
 *
 * @author 
 * @email 
 * @date 2024-04-03 11:54:37
 */
public interface ShiyanshixinxiService extends IService<ShiyanshixinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ShiyanshixinxiView> selectListView(Wrapper<ShiyanshixinxiEntity> wrapper);
   	
   	ShiyanshixinxiView selectView(@Param("ew") Wrapper<ShiyanshixinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ShiyanshixinxiEntity> wrapper);
   	

}

