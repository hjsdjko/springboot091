package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.YaopinchukuEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.YaopinchukuView;


/**
 * 药品出库
 *
 * @author 
 * @email 
 * @date 2024-04-03 11:54:38
 */
public interface YaopinchukuService extends IService<YaopinchukuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YaopinchukuView> selectListView(Wrapper<YaopinchukuEntity> wrapper);
   	
   	YaopinchukuView selectView(@Param("ew") Wrapper<YaopinchukuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YaopinchukuEntity> wrapper);
   	

}

