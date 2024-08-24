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


import com.cl.dao.DiscussshiyankechengDao;
import com.cl.entity.DiscussshiyankechengEntity;
import com.cl.service.DiscussshiyankechengService;
import com.cl.entity.view.DiscussshiyankechengView;

@Service("discussshiyankechengService")
public class DiscussshiyankechengServiceImpl extends ServiceImpl<DiscussshiyankechengDao, DiscussshiyankechengEntity> implements DiscussshiyankechengService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussshiyankechengEntity> page = this.selectPage(
                new Query<DiscussshiyankechengEntity>(params).getPage(),
                new EntityWrapper<DiscussshiyankechengEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussshiyankechengEntity> wrapper) {
		  Page<DiscussshiyankechengView> page =new Query<DiscussshiyankechengView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<DiscussshiyankechengView> selectListView(Wrapper<DiscussshiyankechengEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussshiyankechengView selectView(Wrapper<DiscussshiyankechengEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
