package com.cl.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 实验课程
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-04-03 11:54:38
 */
@TableName("shiyankecheng")
public class ShiyankechengEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public ShiyankechengEntity() {
		
	}
	
	public ShiyankechengEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 实验名称
	 */
					
	private String shiyanmingcheng;
	
	/**
	 * 课程名称
	 */
					
	private String kechengmingcheng;
	
	/**
	 * 封面
	 */
					
	private String fengmian;
	
	/**
	 * 完成时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date wanchengshijian;
	
	/**
	 * 班级
	 */
					
	private String banji;
	
	/**
	 * 指导教师
	 */
					
	private String zhidaojiaoshi;
	
	/**
	 * 实验要求
	 */
					
	private String shiyanyaoqiu;
	
	/**
	 * 实验内容
	 */
					
	private String shiyanneirong;
	
	/**
	 * 发布时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date fabushijian;
	
	/**
	 * 收藏数量
	 */
					
	private Integer storeupnum;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：实验名称
	 */
	public void setShiyanmingcheng(String shiyanmingcheng) {
		this.shiyanmingcheng = shiyanmingcheng;
	}
	/**
	 * 获取：实验名称
	 */
	public String getShiyanmingcheng() {
		return shiyanmingcheng;
	}
	/**
	 * 设置：课程名称
	 */
	public void setKechengmingcheng(String kechengmingcheng) {
		this.kechengmingcheng = kechengmingcheng;
	}
	/**
	 * 获取：课程名称
	 */
	public String getKechengmingcheng() {
		return kechengmingcheng;
	}
	/**
	 * 设置：封面
	 */
	public void setFengmian(String fengmian) {
		this.fengmian = fengmian;
	}
	/**
	 * 获取：封面
	 */
	public String getFengmian() {
		return fengmian;
	}
	/**
	 * 设置：完成时间
	 */
	public void setWanchengshijian(Date wanchengshijian) {
		this.wanchengshijian = wanchengshijian;
	}
	/**
	 * 获取：完成时间
	 */
	public Date getWanchengshijian() {
		return wanchengshijian;
	}
	/**
	 * 设置：班级
	 */
	public void setBanji(String banji) {
		this.banji = banji;
	}
	/**
	 * 获取：班级
	 */
	public String getBanji() {
		return banji;
	}
	/**
	 * 设置：指导教师
	 */
	public void setZhidaojiaoshi(String zhidaojiaoshi) {
		this.zhidaojiaoshi = zhidaojiaoshi;
	}
	/**
	 * 获取：指导教师
	 */
	public String getZhidaojiaoshi() {
		return zhidaojiaoshi;
	}
	/**
	 * 设置：实验要求
	 */
	public void setShiyanyaoqiu(String shiyanyaoqiu) {
		this.shiyanyaoqiu = shiyanyaoqiu;
	}
	/**
	 * 获取：实验要求
	 */
	public String getShiyanyaoqiu() {
		return shiyanyaoqiu;
	}
	/**
	 * 设置：实验内容
	 */
	public void setShiyanneirong(String shiyanneirong) {
		this.shiyanneirong = shiyanneirong;
	}
	/**
	 * 获取：实验内容
	 */
	public String getShiyanneirong() {
		return shiyanneirong;
	}
	/**
	 * 设置：发布时间
	 */
	public void setFabushijian(Date fabushijian) {
		this.fabushijian = fabushijian;
	}
	/**
	 * 获取：发布时间
	 */
	public Date getFabushijian() {
		return fabushijian;
	}
	/**
	 * 设置：收藏数量
	 */
	public void setStoreupnum(Integer storeupnum) {
		this.storeupnum = storeupnum;
	}
	/**
	 * 获取：收藏数量
	 */
	public Integer getStoreupnum() {
		return storeupnum;
	}

}
