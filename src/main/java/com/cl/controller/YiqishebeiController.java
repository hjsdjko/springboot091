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

import com.cl.entity.YiqishebeiEntity;
import com.cl.entity.view.YiqishebeiView;

import com.cl.service.YiqishebeiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;
import com.cl.service.StoreupService;
import com.cl.entity.StoreupEntity;

/**
 * 仪器设备
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-03 11:54:38
 */
@RestController
@RequestMapping("/yiqishebei")
public class YiqishebeiController {
    @Autowired
    private YiqishebeiService yiqishebeiService;

    @Autowired
    private StoreupService storeupService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,YiqishebeiEntity yiqishebei,
		HttpServletRequest request){
        EntityWrapper<YiqishebeiEntity> ew = new EntityWrapper<YiqishebeiEntity>();

		PageUtils page = yiqishebeiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yiqishebei), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,YiqishebeiEntity yiqishebei, 
		HttpServletRequest request){
        EntityWrapper<YiqishebeiEntity> ew = new EntityWrapper<YiqishebeiEntity>();

		PageUtils page = yiqishebeiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yiqishebei), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YiqishebeiEntity yiqishebei){
       	EntityWrapper<YiqishebeiEntity> ew = new EntityWrapper<YiqishebeiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( yiqishebei, "yiqishebei")); 
        return R.ok().put("data", yiqishebeiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YiqishebeiEntity yiqishebei){
        EntityWrapper< YiqishebeiEntity> ew = new EntityWrapper< YiqishebeiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( yiqishebei, "yiqishebei")); 
		YiqishebeiView yiqishebeiView =  yiqishebeiService.selectView(ew);
		return R.ok("查询仪器设备成功").put("data", yiqishebeiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        YiqishebeiEntity yiqishebei = yiqishebeiService.selectById(id);
		yiqishebei = yiqishebeiService.selectView(new EntityWrapper<YiqishebeiEntity>().eq("id", id));
        return R.ok().put("data", yiqishebei);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        YiqishebeiEntity yiqishebei = yiqishebeiService.selectById(id);
		yiqishebei = yiqishebeiService.selectView(new EntityWrapper<YiqishebeiEntity>().eq("id", id));
        return R.ok().put("data", yiqishebei);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody YiqishebeiEntity yiqishebei, HttpServletRequest request){
    	yiqishebei.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yiqishebei);
        yiqishebeiService.insert(yiqishebei);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody YiqishebeiEntity yiqishebei, HttpServletRequest request){
    	yiqishebei.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yiqishebei);
        yiqishebeiService.insert(yiqishebei);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody YiqishebeiEntity yiqishebei, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yiqishebei);
        yiqishebeiService.updateById(yiqishebei);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        yiqishebeiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
