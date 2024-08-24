package com.cl.dao;

import com.cl.entity.YaopinchukuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.YaopinchukuView;


/**
 * 药品出库
 * 
 * @author 
 * @email 
 * @date 2024-04-03 11:54:38
 */
public interface YaopinchukuDao extends BaseMapper<YaopinchukuEntity> {
	
	List<YaopinchukuView> selectListView(@Param("ew") Wrapper<YaopinchukuEntity> wrapper);

	List<YaopinchukuView> selectListView(Pagination page,@Param("ew") Wrapper<YaopinchukuEntity> wrapper);
	
	YaopinchukuView selectView(@Param("ew") Wrapper<YaopinchukuEntity> wrapper);
	

}
