package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.YaopinchukuDao;
import com.cl.entity.YaopinchukuEntity;
import com.cl.service.YaopinchukuService;
import com.cl.entity.view.YaopinchukuView;

@Service("yaopinchukuService")
public class YaopinchukuServiceImpl extends ServiceImpl<YaopinchukuDao, YaopinchukuEntity> implements YaopinchukuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YaopinchukuEntity> page = this.selectPage(
                new Query<YaopinchukuEntity>(params).getPage(),
                new EntityWrapper<YaopinchukuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YaopinchukuEntity> wrapper) {
		  Page<YaopinchukuView> page =new Query<YaopinchukuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<YaopinchukuView> selectListView(Wrapper<YaopinchukuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YaopinchukuView selectView(Wrapper<YaopinchukuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
