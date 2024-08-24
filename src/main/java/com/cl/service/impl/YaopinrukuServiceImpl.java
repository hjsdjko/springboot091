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


import com.cl.dao.YaopinrukuDao;
import com.cl.entity.YaopinrukuEntity;
import com.cl.service.YaopinrukuService;
import com.cl.entity.view.YaopinrukuView;

@Service("yaopinrukuService")
public class YaopinrukuServiceImpl extends ServiceImpl<YaopinrukuDao, YaopinrukuEntity> implements YaopinrukuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YaopinrukuEntity> page = this.selectPage(
                new Query<YaopinrukuEntity>(params).getPage(),
                new EntityWrapper<YaopinrukuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YaopinrukuEntity> wrapper) {
		  Page<YaopinrukuView> page =new Query<YaopinrukuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<YaopinrukuView> selectListView(Wrapper<YaopinrukuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YaopinrukuView selectView(Wrapper<YaopinrukuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
