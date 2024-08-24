package com.cl.dao;

import com.cl.entity.DiscussshiyankechengEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscussshiyankechengView;


/**
 * 实验课程评论表
 * 
 * @author 
 * @email 
 * @date 2024-04-03 11:54:39
 */
public interface DiscussshiyankechengDao extends BaseMapper<DiscussshiyankechengEntity> {
	
	List<DiscussshiyankechengView> selectListView(@Param("ew") Wrapper<DiscussshiyankechengEntity> wrapper);

	List<DiscussshiyankechengView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussshiyankechengEntity> wrapper);
	
	DiscussshiyankechengView selectView(@Param("ew") Wrapper<DiscussshiyankechengEntity> wrapper);
	

}
