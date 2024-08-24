package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.ShiyanyuyueEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ShiyanyuyueView;


/**
 * 实验预约
 *
 * @author 
 * @email 
 * @date 2024-04-03 11:54:38
 */
public interface ShiyanyuyueService extends IService<ShiyanyuyueEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ShiyanyuyueView> selectListView(Wrapper<ShiyanyuyueEntity> wrapper);
   	
   	ShiyanyuyueView selectView(@Param("ew") Wrapper<ShiyanyuyueEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ShiyanyuyueEntity> wrapper);
   	

}

