package com.cl.dao;

import com.cl.entity.ShiyanshiyuyueEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ShiyanshiyuyueView;


/**
 * 实验室预约
 * 
 * @author 
 * @email 
 * @date 2024-04-03 11:54:38
 */
public interface ShiyanshiyuyueDao extends BaseMapper<ShiyanshiyuyueEntity> {
	
	List<ShiyanshiyuyueView> selectListView(@Param("ew") Wrapper<ShiyanshiyuyueEntity> wrapper);

	List<ShiyanshiyuyueView> selectListView(Pagination page,@Param("ew") Wrapper<ShiyanshiyuyueEntity> wrapper);
	
	ShiyanshiyuyueView selectView(@Param("ew") Wrapper<ShiyanshiyuyueEntity> wrapper);
	

}
