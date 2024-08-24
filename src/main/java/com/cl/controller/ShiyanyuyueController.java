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

import com.cl.entity.ShiyanyuyueEntity;
import com.cl.entity.view.ShiyanyuyueView;

import com.cl.service.ShiyanyuyueService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 实验预约
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-03 11:54:38
 */
@RestController
@RequestMapping("/shiyanyuyue")
public class ShiyanyuyueController {
    @Autowired
    private ShiyanyuyueService shiyanyuyueService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ShiyanyuyueEntity shiyanyuyue,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			shiyanyuyue.setZhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ShiyanyuyueEntity> ew = new EntityWrapper<ShiyanyuyueEntity>();

		PageUtils page = shiyanyuyueService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shiyanyuyue), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ShiyanyuyueEntity shiyanyuyue, 
		HttpServletRequest request){
        EntityWrapper<ShiyanyuyueEntity> ew = new EntityWrapper<ShiyanyuyueEntity>();

		PageUtils page = shiyanyuyueService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shiyanyuyue), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ShiyanyuyueEntity shiyanyuyue){
       	EntityWrapper<ShiyanyuyueEntity> ew = new EntityWrapper<ShiyanyuyueEntity>();
      	ew.allEq(MPUtil.allEQMapPre( shiyanyuyue, "shiyanyuyue")); 
        return R.ok().put("data", shiyanyuyueService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ShiyanyuyueEntity shiyanyuyue){
        EntityWrapper< ShiyanyuyueEntity> ew = new EntityWrapper< ShiyanyuyueEntity>();
 		ew.allEq(MPUtil.allEQMapPre( shiyanyuyue, "shiyanyuyue")); 
		ShiyanyuyueView shiyanyuyueView =  shiyanyuyueService.selectView(ew);
		return R.ok("查询实验预约成功").put("data", shiyanyuyueView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ShiyanyuyueEntity shiyanyuyue = shiyanyuyueService.selectById(id);
		shiyanyuyue = shiyanyuyueService.selectView(new EntityWrapper<ShiyanyuyueEntity>().eq("id", id));
        return R.ok().put("data", shiyanyuyue);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ShiyanyuyueEntity shiyanyuyue = shiyanyuyueService.selectById(id);
		shiyanyuyue = shiyanyuyueService.selectView(new EntityWrapper<ShiyanyuyueEntity>().eq("id", id));
        return R.ok().put("data", shiyanyuyue);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ShiyanyuyueEntity shiyanyuyue, HttpServletRequest request){
    	shiyanyuyue.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(shiyanyuyue);
        shiyanyuyueService.insert(shiyanyuyue);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ShiyanyuyueEntity shiyanyuyue, HttpServletRequest request){
    	shiyanyuyue.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(shiyanyuyue);
        shiyanyuyueService.insert(shiyanyuyue);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ShiyanyuyueEntity shiyanyuyue, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shiyanyuyue);
        shiyanyuyueService.updateById(shiyanyuyue);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<ShiyanyuyueEntity> list = new ArrayList<ShiyanyuyueEntity>();
        for(Long id : ids) {
            ShiyanyuyueEntity shiyanyuyue = shiyanyuyueService.selectById(id);
            shiyanyuyue.setSfsh(sfsh);
            shiyanyuyue.setShhf(shhf);
            list.add(shiyanyuyue);
        }
        shiyanyuyueService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        shiyanyuyueService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
