package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.ShiyanshileixingEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ShiyanshileixingView;


/**
 * 实验室类型
 *
 * @author 
 * @email 
 * @date 2024-04-03 11:54:37
 */
public interface ShiyanshileixingService extends IService<ShiyanshileixingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ShiyanshileixingView> selectListView(Wrapper<ShiyanshileixingEntity> wrapper);
   	
   	ShiyanshileixingView selectView(@Param("ew") Wrapper<ShiyanshileixingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ShiyanshileixingEntity> wrapper);
   	

}

