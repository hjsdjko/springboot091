package com.cl.dao;

import com.cl.entity.ShiyanshixinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ShiyanshixinxiView;


/**
 * 实验室信息
 * 
 * @author 
 * @email 
 * @date 2024-04-03 11:54:37
 */
public interface ShiyanshixinxiDao extends BaseMapper<ShiyanshixinxiEntity> {
	
	List<ShiyanshixinxiView> selectListView(@Param("ew") Wrapper<ShiyanshixinxiEntity> wrapper);

	List<ShiyanshixinxiView> selectListView(Pagination page,@Param("ew") Wrapper<ShiyanshixinxiEntity> wrapper);
	
	ShiyanshixinxiView selectView(@Param("ew") Wrapper<ShiyanshixinxiEntity> wrapper);
	

}
