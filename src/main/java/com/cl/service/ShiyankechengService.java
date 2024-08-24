package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.ShiyankechengEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ShiyankechengView;


/**
 * 实验课程
 *
 * @author 
 * @email 
 * @date 2024-04-03 11:54:38
 */
public interface ShiyankechengService extends IService<ShiyankechengEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ShiyankechengView> selectListView(Wrapper<ShiyankechengEntity> wrapper);
   	
   	ShiyankechengView selectView(@Param("ew") Wrapper<ShiyankechengEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ShiyankechengEntity> wrapper);
   	

}

