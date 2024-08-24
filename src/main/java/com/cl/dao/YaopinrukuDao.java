package com.cl.dao;

import com.cl.entity.YaopinrukuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.YaopinrukuView;


/**
 * 药品入库
 * 
 * @author 
 * @email 
 * @date 2024-04-03 11:54:38
 */
public interface YaopinrukuDao extends BaseMapper<YaopinrukuEntity> {
	
	List<YaopinrukuView> selectListView(@Param("ew") Wrapper<YaopinrukuEntity> wrapper);

	List<YaopinrukuView> selectListView(Pagination page,@Param("ew") Wrapper<YaopinrukuEntity> wrapper);
	
	YaopinrukuView selectView(@Param("ew") Wrapper<YaopinrukuEntity> wrapper);
	

}
