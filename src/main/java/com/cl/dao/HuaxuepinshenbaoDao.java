package com.cl.dao;

import com.cl.entity.HuaxuepinshenbaoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.HuaxuepinshenbaoView;


/**
 * 化学品申报
 * 
 * @author 
 * @email 
 * @date 2024-04-03 11:54:38
 */
public interface HuaxuepinshenbaoDao extends BaseMapper<HuaxuepinshenbaoEntity> {
	
	List<HuaxuepinshenbaoView> selectListView(@Param("ew") Wrapper<HuaxuepinshenbaoEntity> wrapper);

	List<HuaxuepinshenbaoView> selectListView(Pagination page,@Param("ew") Wrapper<HuaxuepinshenbaoEntity> wrapper);
	
	HuaxuepinshenbaoView selectView(@Param("ew") Wrapper<HuaxuepinshenbaoEntity> wrapper);
	

}
