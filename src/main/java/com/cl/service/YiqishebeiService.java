package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.YiqishebeiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.YiqishebeiView;


/**
 * 仪器设备
 *
 * @author 
 * @email 
 * @date 2024-04-03 11:54:38
 */
public interface YiqishebeiService extends IService<YiqishebeiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YiqishebeiView> selectListView(Wrapper<YiqishebeiEntity> wrapper);
   	
   	YiqishebeiView selectView(@Param("ew") Wrapper<YiqishebeiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YiqishebeiEntity> wrapper);
   	

}

