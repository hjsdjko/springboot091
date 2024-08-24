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


import com.cl.dao.DiscussshiyanshixinxiDao;
import com.cl.entity.DiscussshiyanshixinxiEntity;
import com.cl.service.DiscussshiyanshixinxiService;
import com.cl.entity.view.DiscussshiyanshixinxiView;

@Service("discussshiyanshixinxiService")
public class DiscussshiyanshixinxiServiceImpl extends ServiceImpl<DiscussshiyanshixinxiDao, DiscussshiyanshixinxiEntity> implements DiscussshiyanshixinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussshiyanshixinxiEntity> page = this.selectPage(
                new Query<DiscussshiyanshixinxiEntity>(params).getPage(),
                new EntityWrapper<DiscussshiyanshixinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussshiyanshixinxiEntity> wrapper) {
		  Page<DiscussshiyanshixinxiView> page =new Query<DiscussshiyanshixinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<DiscussshiyanshixinxiView> selectListView(Wrapper<DiscussshiyanshixinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussshiyanshixinxiView selectView(Wrapper<DiscussshiyanshixinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
