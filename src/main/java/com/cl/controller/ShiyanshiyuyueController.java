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

import com.cl.entity.ShiyanshiyuyueEntity;
import com.cl.entity.view.ShiyanshiyuyueView;

import com.cl.service.ShiyanshiyuyueService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 实验室预约
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-03 11:54:38
 */
@RestController
@RequestMapping("/shiyanshiyuyue")
public class ShiyanshiyuyueController {
    @Autowired
    private ShiyanshiyuyueService shiyanshiyuyueService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ShiyanshiyuyueEntity shiyanshiyuyue,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			shiyanshiyuyue.setZhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ShiyanshiyuyueEntity> ew = new EntityWrapper<ShiyanshiyuyueEntity>();

		PageUtils page = shiyanshiyuyueService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shiyanshiyuyue), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ShiyanshiyuyueEntity shiyanshiyuyue, 
		HttpServletRequest request){
        EntityWrapper<ShiyanshiyuyueEntity> ew = new EntityWrapper<ShiyanshiyuyueEntity>();

		PageUtils page = shiyanshiyuyueService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shiyanshiyuyue), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ShiyanshiyuyueEntity shiyanshiyuyue){
       	EntityWrapper<ShiyanshiyuyueEntity> ew = new EntityWrapper<ShiyanshiyuyueEntity>();
      	ew.allEq(MPUtil.allEQMapPre( shiyanshiyuyue, "shiyanshiyuyue")); 
        return R.ok().put("data", shiyanshiyuyueService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ShiyanshiyuyueEntity shiyanshiyuyue){
        EntityWrapper< ShiyanshiyuyueEntity> ew = new EntityWrapper< ShiyanshiyuyueEntity>();
 		ew.allEq(MPUtil.allEQMapPre( shiyanshiyuyue, "shiyanshiyuyue")); 
		ShiyanshiyuyueView shiyanshiyuyueView =  shiyanshiyuyueService.selectView(ew);
		return R.ok("查询实验室预约成功").put("data", shiyanshiyuyueView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ShiyanshiyuyueEntity shiyanshiyuyue = shiyanshiyuyueService.selectById(id);
		shiyanshiyuyue = shiyanshiyuyueService.selectView(new EntityWrapper<ShiyanshiyuyueEntity>().eq("id", id));
        return R.ok().put("data", shiyanshiyuyue);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ShiyanshiyuyueEntity shiyanshiyuyue = shiyanshiyuyueService.selectById(id);
		shiyanshiyuyue = shiyanshiyuyueService.selectView(new EntityWrapper<ShiyanshiyuyueEntity>().eq("id", id));
        return R.ok().put("data", shiyanshiyuyue);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ShiyanshiyuyueEntity shiyanshiyuyue, HttpServletRequest request){
    	shiyanshiyuyue.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(shiyanshiyuyue);
        shiyanshiyuyueService.insert(shiyanshiyuyue);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ShiyanshiyuyueEntity shiyanshiyuyue, HttpServletRequest request){
    	shiyanshiyuyue.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(shiyanshiyuyue);
        shiyanshiyuyueService.insert(shiyanshiyuyue);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ShiyanshiyuyueEntity shiyanshiyuyue, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shiyanshiyuyue);
        shiyanshiyuyueService.updateById(shiyanshiyuyue);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<ShiyanshiyuyueEntity> list = new ArrayList<ShiyanshiyuyueEntity>();
        for(Long id : ids) {
            ShiyanshiyuyueEntity shiyanshiyuyue = shiyanshiyuyueService.selectById(id);
            shiyanshiyuyue.setSfsh(sfsh);
            shiyanshiyuyue.setShhf(shhf);
            list.add(shiyanshiyuyue);
        }
        shiyanshiyuyueService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        shiyanshiyuyueService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
