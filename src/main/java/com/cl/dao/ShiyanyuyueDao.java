package com.cl.dao;

import com.cl.entity.ShiyanyuyueEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ShiyanyuyueView;


/**
 * 实验预约
 * 
 * @author 
 * @email 
 * @date 2024-04-03 11:54:38
 */
public interface ShiyanyuyueDao extends BaseMapper<ShiyanyuyueEntity> {
	
	List<ShiyanyuyueView> selectListView(@Param("ew") Wrapper<ShiyanyuyueEntity> wrapper);

	List<ShiyanyuyueView> selectListView(Pagination page,@Param("ew") Wrapper<ShiyanyuyueEntity> wrapper);
	
	ShiyanyuyueView selectView(@Param("ew") Wrapper<ShiyanyuyueEntity> wrapper);
	

}
