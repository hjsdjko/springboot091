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

import com.cl.entity.ShiyankechengEntity;
import com.cl.entity.view.ShiyankechengView;

import com.cl.service.ShiyankechengService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;
import com.cl.service.StoreupService;
import com.cl.entity.StoreupEntity;

/**
 * 实验课程
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-03 11:54:38
 */
@RestController
@RequestMapping("/shiyankecheng")
public class ShiyankechengController {
    @Autowired
    private ShiyankechengService shiyankechengService;

    @Autowired
    private StoreupService storeupService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ShiyankechengEntity shiyankecheng,
		HttpServletRequest request){
        EntityWrapper<ShiyankechengEntity> ew = new EntityWrapper<ShiyankechengEntity>();

		PageUtils page = shiyankechengService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shiyankecheng), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ShiyankechengEntity shiyankecheng, 
		HttpServletRequest request){
        EntityWrapper<ShiyankechengEntity> ew = new EntityWrapper<ShiyankechengEntity>();

		PageUtils page = shiyankechengService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shiyankecheng), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ShiyankechengEntity shiyankecheng){
       	EntityWrapper<ShiyankechengEntity> ew = new EntityWrapper<ShiyankechengEntity>();
      	ew.allEq(MPUtil.allEQMapPre( shiyankecheng, "shiyankecheng")); 
        return R.ok().put("data", shiyankechengService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ShiyankechengEntity shiyankecheng){
        EntityWrapper< ShiyankechengEntity> ew = new EntityWrapper< ShiyankechengEntity>();
 		ew.allEq(MPUtil.allEQMapPre( shiyankecheng, "shiyankecheng")); 
		ShiyankechengView shiyankechengView =  shiyankechengService.selectView(ew);
		return R.ok("查询实验课程成功").put("data", shiyankechengView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ShiyankechengEntity shiyankecheng = shiyankechengService.selectById(id);
		shiyankecheng = shiyankechengService.selectView(new EntityWrapper<ShiyankechengEntity>().eq("id", id));
        return R.ok().put("data", shiyankecheng);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ShiyankechengEntity shiyankecheng = shiyankechengService.selectById(id);
		shiyankecheng = shiyankechengService.selectView(new EntityWrapper<ShiyankechengEntity>().eq("id", id));
        return R.ok().put("data", shiyankecheng);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ShiyankechengEntity shiyankecheng, HttpServletRequest request){
    	shiyankecheng.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(shiyankecheng);
        shiyankechengService.insert(shiyankecheng);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ShiyankechengEntity shiyankecheng, HttpServletRequest request){
    	shiyankecheng.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(shiyankecheng);
        shiyankechengService.insert(shiyankecheng);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ShiyankechengEntity shiyankecheng, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shiyankecheng);
        shiyankechengService.updateById(shiyankecheng);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        shiyankechengService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
