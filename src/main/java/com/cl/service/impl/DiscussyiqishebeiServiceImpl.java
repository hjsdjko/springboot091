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


import com.cl.dao.DiscussyiqishebeiDao;
import com.cl.entity.DiscussyiqishebeiEntity;
import com.cl.service.DiscussyiqishebeiService;
import com.cl.entity.view.DiscussyiqishebeiView;

@Service("discussyiqishebeiService")
public class DiscussyiqishebeiServiceImpl extends ServiceImpl<DiscussyiqishebeiDao, DiscussyiqishebeiEntity> implements DiscussyiqishebeiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussyiqishebeiEntity> page = this.selectPage(
                new Query<DiscussyiqishebeiEntity>(params).getPage(),
                new EntityWrapper<DiscussyiqishebeiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussyiqishebeiEntity> wrapper) {
		  Page<DiscussyiqishebeiView> page =new Query<DiscussyiqishebeiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<DiscussyiqishebeiView> selectListView(Wrapper<DiscussyiqishebeiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussyiqishebeiView selectView(Wrapper<DiscussyiqishebeiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
