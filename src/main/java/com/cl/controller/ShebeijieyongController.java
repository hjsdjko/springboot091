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

import com.cl.entity.ShebeijieyongEntity;
import com.cl.entity.view.ShebeijieyongView;

import com.cl.service.ShebeijieyongService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 设备借用
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-03 11:54:38
 */
@RestController
@RequestMapping("/shebeijieyong")
public class ShebeijieyongController {
    @Autowired
    private ShebeijieyongService shebeijieyongService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ShebeijieyongEntity shebeijieyong,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			shebeijieyong.setZhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ShebeijieyongEntity> ew = new EntityWrapper<ShebeijieyongEntity>();

		PageUtils page = shebeijieyongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shebeijieyong), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ShebeijieyongEntity shebeijieyong, 
		HttpServletRequest request){
        EntityWrapper<ShebeijieyongEntity> ew = new EntityWrapper<ShebeijieyongEntity>();

		PageUtils page = shebeijieyongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shebeijieyong), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ShebeijieyongEntity shebeijieyong){
       	EntityWrapper<ShebeijieyongEntity> ew = new EntityWrapper<ShebeijieyongEntity>();
      	ew.allEq(MPUtil.allEQMapPre( shebeijieyong, "shebeijieyong")); 
        return R.ok().put("data", shebeijieyongService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ShebeijieyongEntity shebeijieyong){
        EntityWrapper< ShebeijieyongEntity> ew = new EntityWrapper< ShebeijieyongEntity>();
 		ew.allEq(MPUtil.allEQMapPre( shebeijieyong, "shebeijieyong")); 
		ShebeijieyongView shebeijieyongView =  shebeijieyongService.selectView(ew);
		return R.ok("查询设备借用成功").put("data", shebeijieyongView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ShebeijieyongEntity shebeijieyong = shebeijieyongService.selectById(id);
		shebeijieyong = shebeijieyongService.selectView(new EntityWrapper<ShebeijieyongEntity>().eq("id", id));
        return R.ok().put("data", shebeijieyong);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ShebeijieyongEntity shebeijieyong = shebeijieyongService.selectById(id);
		shebeijieyong = shebeijieyongService.selectView(new EntityWrapper<ShebeijieyongEntity>().eq("id", id));
        return R.ok().put("data", shebeijieyong);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ShebeijieyongEntity shebeijieyong, HttpServletRequest request){
    	shebeijieyong.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(shebeijieyong);
        shebeijieyongService.insert(shebeijieyong);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ShebeijieyongEntity shebeijieyong, HttpServletRequest request){
    	shebeijieyong.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(shebeijieyong);
        shebeijieyongService.insert(shebeijieyong);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ShebeijieyongEntity shebeijieyong, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shebeijieyong);
        shebeijieyongService.updateById(shebeijieyong);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<ShebeijieyongEntity> list = new ArrayList<ShebeijieyongEntity>();
        for(Long id : ids) {
            ShebeijieyongEntity shebeijieyong = shebeijieyongService.selectById(id);
            shebeijieyong.setSfsh(sfsh);
            shebeijieyong.setShhf(shhf);
            list.add(shebeijieyong);
        }
        shebeijieyongService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        shebeijieyongService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
