package com.cl.dao;

import com.cl.entity.ShijiyaopinEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ShijiyaopinView;


/**
 * 试剂药品
 * 
 * @author 
 * @email 
 * @date 2024-04-03 11:54:38
 */
public interface ShijiyaopinDao extends BaseMapper<ShijiyaopinEntity> {
	
	List<ShijiyaopinView> selectListView(@Param("ew") Wrapper<ShijiyaopinEntity> wrapper);

	List<ShijiyaopinView> selectListView(Pagination page,@Param("ew") Wrapper<ShijiyaopinEntity> wrapper);
	
	ShijiyaopinView selectView(@Param("ew") Wrapper<ShijiyaopinEntity> wrapper);
	

}
