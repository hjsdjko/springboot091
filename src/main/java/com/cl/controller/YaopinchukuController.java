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

import com.cl.entity.YaopinchukuEntity;
import com.cl.entity.view.YaopinchukuView;

import com.cl.service.YaopinchukuService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 药品出库
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-03 11:54:38
 */
@RestController
@RequestMapping("/yaopinchuku")
public class YaopinchukuController {
    @Autowired
    private YaopinchukuService yaopinchukuService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,YaopinchukuEntity yaopinchuku,
		HttpServletRequest request){
        EntityWrapper<YaopinchukuEntity> ew = new EntityWrapper<YaopinchukuEntity>();

		PageUtils page = yaopinchukuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yaopinchuku), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,YaopinchukuEntity yaopinchuku, 
		HttpServletRequest request){
        EntityWrapper<YaopinchukuEntity> ew = new EntityWrapper<YaopinchukuEntity>();

		PageUtils page = yaopinchukuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yaopinchuku), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YaopinchukuEntity yaopinchuku){
       	EntityWrapper<YaopinchukuEntity> ew = new EntityWrapper<YaopinchukuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( yaopinchuku, "yaopinchuku")); 
        return R.ok().put("data", yaopinchukuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YaopinchukuEntity yaopinchuku){
        EntityWrapper< YaopinchukuEntity> ew = new EntityWrapper< YaopinchukuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( yaopinchuku, "yaopinchuku")); 
		YaopinchukuView yaopinchukuView =  yaopinchukuService.selectView(ew);
		return R.ok("查询药品出库成功").put("data", yaopinchukuView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        YaopinchukuEntity yaopinchuku = yaopinchukuService.selectById(id);
		yaopinchuku = yaopinchukuService.selectView(new EntityWrapper<YaopinchukuEntity>().eq("id", id));
        return R.ok().put("data", yaopinchuku);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        YaopinchukuEntity yaopinchuku = yaopinchukuService.selectById(id);
		yaopinchuku = yaopinchukuService.selectView(new EntityWrapper<YaopinchukuEntity>().eq("id", id));
        return R.ok().put("data", yaopinchuku);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody YaopinchukuEntity yaopinchuku, HttpServletRequest request){
    	yaopinchuku.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yaopinchuku);
        yaopinchukuService.insert(yaopinchuku);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody YaopinchukuEntity yaopinchuku, HttpServletRequest request){
    	yaopinchuku.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yaopinchuku);
        yaopinchukuService.insert(yaopinchuku);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody YaopinchukuEntity yaopinchuku, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yaopinchuku);
        yaopinchukuService.updateById(yaopinchuku);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        yaopinchukuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
