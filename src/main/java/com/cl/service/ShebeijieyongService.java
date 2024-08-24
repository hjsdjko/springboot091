package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.ShebeijieyongEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ShebeijieyongView;


/**
 * 设备借用
 *
 * @author 
 * @email 
 * @date 2024-04-03 11:54:38
 */
public interface ShebeijieyongService extends IService<ShebeijieyongEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ShebeijieyongView> selectListView(Wrapper<ShebeijieyongEntity> wrapper);
   	
   	ShebeijieyongView selectView(@Param("ew") Wrapper<ShebeijieyongEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ShebeijieyongEntity> wrapper);
   	

}

