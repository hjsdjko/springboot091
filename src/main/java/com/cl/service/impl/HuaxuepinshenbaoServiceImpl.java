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


import com.cl.dao.HuaxuepinshenbaoDao;
import com.cl.entity.HuaxuepinshenbaoEntity;
import com.cl.service.HuaxuepinshenbaoService;
import com.cl.entity.view.HuaxuepinshenbaoView;

@Service("huaxuepinshenbaoService")
public class HuaxuepinshenbaoServiceImpl extends ServiceImpl<HuaxuepinshenbaoDao, HuaxuepinshenbaoEntity> implements HuaxuepinshenbaoService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<HuaxuepinshenbaoEntity> page = this.selectPage(
                new Query<HuaxuepinshenbaoEntity>(params).getPage(),
                new EntityWrapper<HuaxuepinshenbaoEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<HuaxuepinshenbaoEntity> wrapper) {
		  Page<HuaxuepinshenbaoView> page =new Query<HuaxuepinshenbaoView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<HuaxuepinshenbaoView> selectListView(Wrapper<HuaxuepinshenbaoEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public HuaxuepinshenbaoView selectView(Wrapper<HuaxuepinshenbaoEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
