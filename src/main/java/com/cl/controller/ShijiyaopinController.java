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

import com.cl.entity.ShijiyaopinEntity;
import com.cl.entity.view.ShijiyaopinView;

import com.cl.service.ShijiyaopinService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 试剂药品
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-03 11:54:38
 */
@RestController
@RequestMapping("/shijiyaopin")
public class ShijiyaopinController {
    @Autowired
    private ShijiyaopinService shijiyaopinService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ShijiyaopinEntity shijiyaopin,
		HttpServletRequest request){
        EntityWrapper<ShijiyaopinEntity> ew = new EntityWrapper<ShijiyaopinEntity>();

		PageUtils page = shijiyaopinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shijiyaopin), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ShijiyaopinEntity shijiyaopin, 
		HttpServletRequest request){
        EntityWrapper<ShijiyaopinEntity> ew = new EntityWrapper<ShijiyaopinEntity>();

		PageUtils page = shijiyaopinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shijiyaopin), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ShijiyaopinEntity shijiyaopin){
       	EntityWrapper<ShijiyaopinEntity> ew = new EntityWrapper<ShijiyaopinEntity>();
      	ew.allEq(MPUtil.allEQMapPre( shijiyaopin, "shijiyaopin")); 
        return R.ok().put("data", shijiyaopinService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ShijiyaopinEntity shijiyaopin){
        EntityWrapper< ShijiyaopinEntity> ew = new EntityWrapper< ShijiyaopinEntity>();
 		ew.allEq(MPUtil.allEQMapPre( shijiyaopin, "shijiyaopin")); 
		ShijiyaopinView shijiyaopinView =  shijiyaopinService.selectView(ew);
		return R.ok("查询试剂药品成功").put("data", shijiyaopinView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ShijiyaopinEntity shijiyaopin = shijiyaopinService.selectById(id);
		shijiyaopin = shijiyaopinService.selectView(new EntityWrapper<ShijiyaopinEntity>().eq("id", id));
        return R.ok().put("data", shijiyaopin);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ShijiyaopinEntity shijiyaopin = shijiyaopinService.selectById(id);
		shijiyaopin = shijiyaopinService.selectView(new EntityWrapper<ShijiyaopinEntity>().eq("id", id));
        return R.ok().put("data", shijiyaopin);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ShijiyaopinEntity shijiyaopin, HttpServletRequest request){
    	shijiyaopin.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(shijiyaopin);
        shijiyaopinService.insert(shijiyaopin);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ShijiyaopinEntity shijiyaopin, HttpServletRequest request){
    	shijiyaopin.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(shijiyaopin);
        shijiyaopinService.insert(shijiyaopin);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ShijiyaopinEntity shijiyaopin, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shijiyaopin);
        shijiyaopinService.updateById(shijiyaopin);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        shijiyaopinService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
