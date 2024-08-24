package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.ShiyanshiyuyueEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ShiyanshiyuyueView;


/**
 * 实验室预约
 *
 * @author 
 * @email 
 * @date 2024-04-03 11:54:38
 */
public interface ShiyanshiyuyueService extends IService<ShiyanshiyuyueEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ShiyanshiyuyueView> selectListView(Wrapper<ShiyanshiyuyueEntity> wrapper);
   	
   	ShiyanshiyuyueView selectView(@Param("ew") Wrapper<ShiyanshiyuyueEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ShiyanshiyuyueEntity> wrapper);
   	

}

