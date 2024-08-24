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


import com.cl.dao.YiqishebeiDao;
import com.cl.entity.YiqishebeiEntity;
import com.cl.service.YiqishebeiService;
import com.cl.entity.view.YiqishebeiView;

@Service("yiqishebeiService")
public class YiqishebeiServiceImpl extends ServiceImpl<YiqishebeiDao, YiqishebeiEntity> implements YiqishebeiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YiqishebeiEntity> page = this.selectPage(
                new Query<YiqishebeiEntity>(params).getPage(),
                new EntityWrapper<YiqishebeiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YiqishebeiEntity> wrapper) {
		  Page<YiqishebeiView> page =new Query<YiqishebeiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<YiqishebeiView> selectListView(Wrapper<YiqishebeiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YiqishebeiView selectView(Wrapper<YiqishebeiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
