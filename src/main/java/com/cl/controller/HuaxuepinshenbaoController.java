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

import com.cl.entity.HuaxuepinshenbaoEntity;
import com.cl.entity.view.HuaxuepinshenbaoView;

import com.cl.service.HuaxuepinshenbaoService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 化学品申报
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-03 11:54:38
 */
@RestController
@RequestMapping("/huaxuepinshenbao")
public class HuaxuepinshenbaoController {
    @Autowired
    private HuaxuepinshenbaoService huaxuepinshenbaoService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,HuaxuepinshenbaoEntity huaxuepinshenbao,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			huaxuepinshenbao.setZhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<HuaxuepinshenbaoEntity> ew = new EntityWrapper<HuaxuepinshenbaoEntity>();

		PageUtils page = huaxuepinshenbaoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, huaxuepinshenbao), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,HuaxuepinshenbaoEntity huaxuepinshenbao, 
		HttpServletRequest request){
        EntityWrapper<HuaxuepinshenbaoEntity> ew = new EntityWrapper<HuaxuepinshenbaoEntity>();

		PageUtils page = huaxuepinshenbaoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, huaxuepinshenbao), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( HuaxuepinshenbaoEntity huaxuepinshenbao){
       	EntityWrapper<HuaxuepinshenbaoEntity> ew = new EntityWrapper<HuaxuepinshenbaoEntity>();
      	ew.allEq(MPUtil.allEQMapPre( huaxuepinshenbao, "huaxuepinshenbao")); 
        return R.ok().put("data", huaxuepinshenbaoService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(HuaxuepinshenbaoEntity huaxuepinshenbao){
        EntityWrapper< HuaxuepinshenbaoEntity> ew = new EntityWrapper< HuaxuepinshenbaoEntity>();
 		ew.allEq(MPUtil.allEQMapPre( huaxuepinshenbao, "huaxuepinshenbao")); 
		HuaxuepinshenbaoView huaxuepinshenbaoView =  huaxuepinshenbaoService.selectView(ew);
		return R.ok("查询化学品申报成功").put("data", huaxuepinshenbaoView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        HuaxuepinshenbaoEntity huaxuepinshenbao = huaxuepinshenbaoService.selectById(id);
		huaxuepinshenbao = huaxuepinshenbaoService.selectView(new EntityWrapper<HuaxuepinshenbaoEntity>().eq("id", id));
        return R.ok().put("data", huaxuepinshenbao);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        HuaxuepinshenbaoEntity huaxuepinshenbao = huaxuepinshenbaoService.selectById(id);
		huaxuepinshenbao = huaxuepinshenbaoService.selectView(new EntityWrapper<HuaxuepinshenbaoEntity>().eq("id", id));
        return R.ok().put("data", huaxuepinshenbao);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody HuaxuepinshenbaoEntity huaxuepinshenbao, HttpServletRequest request){
    	huaxuepinshenbao.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(huaxuepinshenbao);
        huaxuepinshenbaoService.insert(huaxuepinshenbao);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody HuaxuepinshenbaoEntity huaxuepinshenbao, HttpServletRequest request){
    	huaxuepinshenbao.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(huaxuepinshenbao);
        huaxuepinshenbaoService.insert(huaxuepinshenbao);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody HuaxuepinshenbaoEntity huaxuepinshenbao, HttpServletRequest request){
        //ValidatorUtils.validateEntity(huaxuepinshenbao);
        huaxuepinshenbaoService.updateById(huaxuepinshenbao);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<HuaxuepinshenbaoEntity> list = new ArrayList<HuaxuepinshenbaoEntity>();
        for(Long id : ids) {
            HuaxuepinshenbaoEntity huaxuepinshenbao = huaxuepinshenbaoService.selectById(id);
            huaxuepinshenbao.setSfsh(sfsh);
            huaxuepinshenbao.setShhf(shhf);
            list.add(huaxuepinshenbao);
        }
        huaxuepinshenbaoService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        huaxuepinshenbaoService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
