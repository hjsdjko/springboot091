package com.cl.dao;

import com.cl.entity.ShebeijieyongEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ShebeijieyongView;


/**
 * 设备借用
 * 
 * @author 
 * @email 
 * @date 2024-04-03 11:54:38
 */
public interface ShebeijieyongDao extends BaseMapper<ShebeijieyongEntity> {
	
	List<ShebeijieyongView> selectListView(@Param("ew") Wrapper<ShebeijieyongEntity> wrapper);

	List<ShebeijieyongView> selectListView(Pagination page,@Param("ew") Wrapper<ShebeijieyongEntity> wrapper);
	
	ShebeijieyongView selectView(@Param("ew") Wrapper<ShebeijieyongEntity> wrapper);
	

}
