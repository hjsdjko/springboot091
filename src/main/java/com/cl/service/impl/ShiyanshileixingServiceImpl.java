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


import com.cl.dao.ShiyanshileixingDao;
import com.cl.entity.ShiyanshileixingEntity;
import com.cl.service.ShiyanshileixingService;
import com.cl.entity.view.ShiyanshileixingView;

@Service("shiyanshileixingService")
public class ShiyanshileixingServiceImpl extends ServiceImpl<ShiyanshileixingDao, ShiyanshileixingEntity> implements ShiyanshileixingService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShiyanshileixingEntity> page = this.selectPage(
                new Query<ShiyanshileixingEntity>(params).getPage(),
                new EntityWrapper<ShiyanshileixingEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ShiyanshileixingEntity> wrapper) {
		  Page<ShiyanshileixingView> page =new Query<ShiyanshileixingView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<ShiyanshileixingView> selectListView(Wrapper<ShiyanshileixingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ShiyanshileixingView selectView(Wrapper<ShiyanshileixingEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
