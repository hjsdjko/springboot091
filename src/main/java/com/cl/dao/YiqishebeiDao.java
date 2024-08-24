package com.cl.dao;

import com.cl.entity.YiqishebeiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.YiqishebeiView;


/**
 * 仪器设备
 * 
 * @author 
 * @email 
 * @date 2024-04-03 11:54:38
 */
public interface YiqishebeiDao extends BaseMapper<YiqishebeiEntity> {
	
	List<YiqishebeiView> selectListView(@Param("ew") Wrapper<YiqishebeiEntity> wrapper);

	List<YiqishebeiView> selectListView(Pagination page,@Param("ew") Wrapper<YiqishebeiEntity> wrapper);
	
	YiqishebeiView selectView(@Param("ew") Wrapper<YiqishebeiEntity> wrapper);
	

}
