package com.cl.dao;

import com.cl.entity.ShiyankechengEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ShiyankechengView;


/**
 * 实验课程
 * 
 * @author 
 * @email 
 * @date 2024-04-03 11:54:38
 */
public interface ShiyankechengDao extends BaseMapper<ShiyankechengEntity> {
	
	List<ShiyankechengView> selectListView(@Param("ew") Wrapper<ShiyankechengEntity> wrapper);

	List<ShiyankechengView> selectListView(Pagination page,@Param("ew") Wrapper<ShiyankechengEntity> wrapper);
	
	ShiyankechengView selectView(@Param("ew") Wrapper<ShiyankechengEntity> wrapper);
	

}
