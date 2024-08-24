package com.cl.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.cl.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.cl.annotation.IgnoreAuth;

import com.cl.entity.DiscussshiyanshixinxiEntity;
import com.cl.entity.view.DiscussshiyanshixinxiView;

import com.cl.service.DiscussshiyanshixinxiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 实验室信息评论表
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-03 11:54:38
 */
@RestController
@RequestMapping("/discussshiyanshixinxi")
public class DiscussshiyanshixinxiController {
    @Autowired
    private DiscussshiyanshixinxiService discussshiyanshixinxiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DiscussshiyanshixinxiEntity discussshiyanshixinxi,
		HttpServletRequest request){
        EntityWrapper<DiscussshiyanshixinxiEntity> ew = new EntityWrapper<DiscussshiyanshixinxiEntity>();

		PageUtils page = discussshiyanshixinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussshiyanshixinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DiscussshiyanshixinxiEntity discussshiyanshixinxi, 
		HttpServletRequest request){
        EntityWrapper<DiscussshiyanshixinxiEntity> ew = new EntityWrapper<DiscussshiyanshixinxiEntity>();

		PageUtils page = discussshiyanshixinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussshiyanshixinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DiscussshiyanshixinxiEntity discussshiyanshixinxi){
       	EntityWrapper<DiscussshiyanshixinxiEntity> ew = new EntityWrapper<DiscussshiyanshixinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( discussshiyanshixinxi, "discussshiyanshixinxi")); 
        return R.ok().put("data", discussshiyanshixinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DiscussshiyanshixinxiEntity discussshiyanshixinxi){
        EntityWrapper< DiscussshiyanshixinxiEntity> ew = new EntityWrapper< DiscussshiyanshixinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( discussshiyanshixinxi, "discussshiyanshixinxi")); 
		DiscussshiyanshixinxiView discussshiyanshixinxiView =  discussshiyanshixinxiService.selectView(ew);
		return R.ok("查询实验室信息评论表成功").put("data", discussshiyanshixinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DiscussshiyanshixinxiEntity discussshiyanshixinxi = discussshiyanshixinxiService.selectById(id);
		discussshiyanshixinxi = discussshiyanshixinxiService.selectView(new EntityWrapper<DiscussshiyanshixinxiEntity>().eq("id", id));
        return R.ok().put("data", discussshiyanshixinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DiscussshiyanshixinxiEntity discussshiyanshixinxi = discussshiyanshixinxiService.selectById(id);
		discussshiyanshixinxi = discussshiyanshixinxiService.selectView(new EntityWrapper<DiscussshiyanshixinxiEntity>().eq("id", id));
        return R.ok().put("data", discussshiyanshixinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DiscussshiyanshixinxiEntity discussshiyanshixinxi, HttpServletRequest request){
    	discussshiyanshixinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discussshiyanshixinxi);
        discussshiyanshixinxiService.insert(discussshiyanshixinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DiscussshiyanshixinxiEntity discussshiyanshixinxi, HttpServletRequest request){
    	discussshiyanshixinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discussshiyanshixinxi);
        discussshiyanshixinxiService.insert(discussshiyanshixinxi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @IgnoreAuth
    public R update(@RequestBody DiscussshiyanshixinxiEntity discussshiyanshixinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discussshiyanshixinxi);
        discussshiyanshixinxiService.updateById(discussshiyanshixinxi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        discussshiyanshixinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,DiscussshiyanshixinxiEntity discussshiyanshixinxi, HttpServletRequest request,String pre){
        EntityWrapper<DiscussshiyanshixinxiEntity> ew = new EntityWrapper<DiscussshiyanshixinxiEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicktime");
        params.put("order", "desc");
		PageUtils page = discussshiyanshixinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussshiyanshixinxi), params), params));
        return R.ok().put("data", page);
    }








}
