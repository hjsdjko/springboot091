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


import com.cl.dao.ShijiyaopinDao;
import com.cl.entity.ShijiyaopinEntity;
import com.cl.service.ShijiyaopinService;
import com.cl.entity.view.ShijiyaopinView;

@Service("shijiyaopinService")
public class ShijiyaopinServiceImpl extends ServiceImpl<ShijiyaopinDao, ShijiyaopinEntity> implements ShijiyaopinService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShijiyaopinEntity> page = this.selectPage(
                new Query<ShijiyaopinEntity>(params).getPage(),
                new EntityWrapper<ShijiyaopinEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ShijiyaopinEntity> wrapper) {
		  Page<ShijiyaopinView> page =new Query<ShijiyaopinView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<ShijiyaopinView> selectListView(Wrapper<ShijiyaopinEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ShijiyaopinView selectView(Wrapper<ShijiyaopinEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
