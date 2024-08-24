package com.cl.dao;

import com.cl.entity.ShiyanshileixingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ShiyanshileixingView;


/**
 * 实验室类型
 * 
 * @author 
 * @email 
 * @date 2024-04-03 11:54:37
 */
public interface ShiyanshileixingDao extends BaseMapper<ShiyanshileixingEntity> {
	
	List<ShiyanshileixingView> selectListView(@Param("ew") Wrapper<ShiyanshileixingEntity> wrapper);

	List<ShiyanshileixingView> selectListView(Pagination page,@Param("ew") Wrapper<ShiyanshileixingEntity> wrapper);
	
	ShiyanshileixingView selectView(@Param("ew") Wrapper<ShiyanshileixingEntity> wrapper);
	

}
