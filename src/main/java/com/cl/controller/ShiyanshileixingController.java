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

import com.cl.entity.ShiyanshileixingEntity;
import com.cl.entity.view.ShiyanshileixingView;

import com.cl.service.ShiyanshileixingService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 实验室类型
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-03 11:54:37
 */
@RestController
@RequestMapping("/shiyanshileixing")
public class ShiyanshileixingController {
    @Autowired
    private ShiyanshileixingService shiyanshileixingService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ShiyanshileixingEntity shiyanshileixing,
		HttpServletRequest request){
        EntityWrapper<ShiyanshileixingEntity> ew = new EntityWrapper<ShiyanshileixingEntity>();

		PageUtils page = shiyanshileixingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shiyanshileixing), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ShiyanshileixingEntity shiyanshileixing, 
		HttpServletRequest request){
        EntityWrapper<ShiyanshileixingEntity> ew = new EntityWrapper<ShiyanshileixingEntity>();

		PageUtils page = shiyanshileixingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shiyanshileixing), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ShiyanshileixingEntity shiyanshileixing){
       	EntityWrapper<ShiyanshileixingEntity> ew = new EntityWrapper<ShiyanshileixingEntity>();
      	ew.allEq(MPUtil.allEQMapPre( shiyanshileixing, "shiyanshileixing")); 
        return R.ok().put("data", shiyanshileixingService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ShiyanshileixingEntity shiyanshileixing){
        EntityWrapper< ShiyanshileixingEntity> ew = new EntityWrapper< ShiyanshileixingEntity>();
 		ew.allEq(MPUtil.allEQMapPre( shiyanshileixing, "shiyanshileixing")); 
		ShiyanshileixingView shiyanshileixingView =  shiyanshileixingService.selectView(ew);
		return R.ok("查询实验室类型成功").put("data", shiyanshileixingView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ShiyanshileixingEntity shiyanshileixing = shiyanshileixingService.selectById(id);
		shiyanshileixing = shiyanshileixingService.selectView(new EntityWrapper<ShiyanshileixingEntity>().eq("id", id));
        return R.ok().put("data", shiyanshileixing);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ShiyanshileixingEntity shiyanshileixing = shiyanshileixingService.selectById(id);
		shiyanshileixing = shiyanshileixingService.selectView(new EntityWrapper<ShiyanshileixingEntity>().eq("id", id));
        return R.ok().put("data", shiyanshileixing);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ShiyanshileixingEntity shiyanshileixing, HttpServletRequest request){
    	shiyanshileixing.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(shiyanshileixing);
        shiyanshileixingService.insert(shiyanshileixing);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ShiyanshileixingEntity shiyanshileixing, HttpServletRequest request){
    	shiyanshileixing.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(shiyanshileixing);
        shiyanshileixingService.insert(shiyanshileixing);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ShiyanshileixingEntity shiyanshileixing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shiyanshileixing);
        shiyanshileixingService.updateById(shiyanshileixing);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        shiyanshileixingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
