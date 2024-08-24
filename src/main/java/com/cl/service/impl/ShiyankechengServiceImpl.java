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


import com.cl.dao.ShiyankechengDao;
import com.cl.entity.ShiyankechengEntity;
import com.cl.service.ShiyankechengService;
import com.cl.entity.view.ShiyankechengView;

@Service("shiyankechengService")
public class ShiyankechengServiceImpl extends ServiceImpl<ShiyankechengDao, ShiyankechengEntity> implements ShiyankechengService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShiyankechengEntity> page = this.selectPage(
                new Query<ShiyankechengEntity>(params).getPage(),
                new EntityWrapper<ShiyankechengEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ShiyankechengEntity> wrapper) {
		  Page<ShiyankechengView> page =new Query<ShiyankechengView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<ShiyankechengView> selectListView(Wrapper<ShiyankechengEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ShiyankechengView selectView(Wrapper<ShiyankechengEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
