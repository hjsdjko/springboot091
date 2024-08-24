package com.cl.dao;

import com.cl.entity.DiscussyiqishebeiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscussyiqishebeiView;


/**
 * 仪器设备评论表
 * 
 * @author 
 * @email 
 * @date 2024-04-03 11:54:38
 */
public interface DiscussyiqishebeiDao extends BaseMapper<DiscussyiqishebeiEntity> {
	
	List<DiscussyiqishebeiView> selectListView(@Param("ew") Wrapper<DiscussyiqishebeiEntity> wrapper);

	List<DiscussyiqishebeiView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussyiqishebeiEntity> wrapper);
	
	DiscussyiqishebeiView selectView(@Param("ew") Wrapper<DiscussyiqishebeiEntity> wrapper);
	

}
