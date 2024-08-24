package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.ShijiyaopinEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ShijiyaopinView;


/**
 * 试剂药品
 *
 * @author 
 * @email 
 * @date 2024-04-03 11:54:38
 */
public interface ShijiyaopinService extends IService<ShijiyaopinEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ShijiyaopinView> selectListView(Wrapper<ShijiyaopinEntity> wrapper);
   	
   	ShijiyaopinView selectView(@Param("ew") Wrapper<ShijiyaopinEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ShijiyaopinEntity> wrapper);
   	

}

