package com.cl.dao;

import com.cl.entity.DiscussshiyanshixinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscussshiyanshixinxiView;


/**
 * 实验室信息评论表
 * 
 * @author 
 * @email 
 * @date 2024-04-03 11:54:38
 */
public interface DiscussshiyanshixinxiDao extends BaseMapper<DiscussshiyanshixinxiEntity> {
	
	List<DiscussshiyanshixinxiView> selectListView(@Param("ew") Wrapper<DiscussshiyanshixinxiEntity> wrapper);

	List<DiscussshiyanshixinxiView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussshiyanshixinxiEntity> wrapper);
	
	DiscussshiyanshixinxiView selectView(@Param("ew") Wrapper<DiscussshiyanshixinxiEntity> wrapper);
	

}
