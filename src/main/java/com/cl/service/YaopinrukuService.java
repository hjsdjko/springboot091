package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.YaopinrukuEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.YaopinrukuView;


/**
 * 药品入库
 *
 * @author 
 * @email 
 * @date 2024-04-03 11:54:38
 */
public interface YaopinrukuService extends IService<YaopinrukuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YaopinrukuView> selectListView(Wrapper<YaopinrukuEntity> wrapper);
   	
   	YaopinrukuView selectView(@Param("ew") Wrapper<YaopinrukuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YaopinrukuEntity> wrapper);
   	

}

