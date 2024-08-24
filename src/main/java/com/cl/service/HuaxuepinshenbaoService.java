package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.HuaxuepinshenbaoEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.HuaxuepinshenbaoView;


/**
 * 化学品申报
 *
 * @author 
 * @email 
 * @date 2024-04-03 11:54:38
 */
public interface HuaxuepinshenbaoService extends IService<HuaxuepinshenbaoEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<HuaxuepinshenbaoView> selectListView(Wrapper<HuaxuepinshenbaoEntity> wrapper);
   	
   	HuaxuepinshenbaoView selectView(@Param("ew") Wrapper<HuaxuepinshenbaoEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<HuaxuepinshenbaoEntity> wrapper);
   	

}

