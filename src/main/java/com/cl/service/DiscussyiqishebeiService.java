package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.DiscussyiqishebeiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscussyiqishebeiView;


/**
 * 仪器设备评论表
 *
 * @author 
 * @email 
 * @date 2024-04-03 11:54:38
 */
public interface DiscussyiqishebeiService extends IService<DiscussyiqishebeiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussyiqishebeiView> selectListView(Wrapper<DiscussyiqishebeiEntity> wrapper);
   	
   	DiscussyiqishebeiView selectView(@Param("ew") Wrapper<DiscussyiqishebeiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussyiqishebeiEntity> wrapper);
   	

}

