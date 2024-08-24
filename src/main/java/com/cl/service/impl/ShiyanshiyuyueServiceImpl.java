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


import com.cl.dao.ShiyanshiyuyueDao;
import com.cl.entity.ShiyanshiyuyueEntity;
import com.cl.service.ShiyanshiyuyueService;
import com.cl.entity.view.ShiyanshiyuyueView;

@Service("shiyanshiyuyueService")
public class ShiyanshiyuyueServiceImpl extends ServiceImpl<ShiyanshiyuyueDao, ShiyanshiyuyueEntity> implements ShiyanshiyuyueService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShiyanshiyuyueEntity> page = this.selectPage(
                new Query<ShiyanshiyuyueEntity>(params).getPage(),
                new EntityWrapper<ShiyanshiyuyueEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ShiyanshiyuyueEntity> wrapper) {
		  Page<ShiyanshiyuyueView> page =new Query<ShiyanshiyuyueView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<ShiyanshiyuyueView> selectListView(Wrapper<ShiyanshiyuyueEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ShiyanshiyuyueView selectView(Wrapper<ShiyanshiyuyueEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
