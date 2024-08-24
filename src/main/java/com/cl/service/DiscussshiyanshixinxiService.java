package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.DiscussshiyanshixinxiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscussshiyanshixinxiView;


/**
 * 实验室信息评论表
 *
 * @author 
 * @email 
 * @date 2024-04-03 11:54:38
 */
public interface DiscussshiyanshixinxiService extends IService<DiscussshiyanshixinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussshiyanshixinxiView> selectListView(Wrapper<DiscussshiyanshixinxiEntity> wrapper);
   	
   	DiscussshiyanshixinxiView selectView(@Param("ew") Wrapper<DiscussshiyanshixinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussshiyanshixinxiEntity> wrapper);
   	

}

