package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.DiscussshiyankechengEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscussshiyankechengView;


/**
 * 实验课程评论表
 *
 * @author 
 * @email 
 * @date 2024-04-03 11:54:39
 */
public interface DiscussshiyankechengService extends IService<DiscussshiyankechengEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussshiyankechengView> selectListView(Wrapper<DiscussshiyankechengEntity> wrapper);
   	
   	DiscussshiyankechengView selectView(@Param("ew") Wrapper<DiscussshiyankechengEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussshiyankechengEntity> wrapper);
   	

}

