package com.entity;

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
 * 缺陷信息
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-05-06 16:46:57
 */
@TableName("quexianxinxi")
public class QuexianxinxiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public QuexianxinxiEntity() {
		
	}
	
	public QuexianxinxiEntity(T t) {
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
    @TableId(type = IdType.AUTO)
    private Long id;
	/**
	 * 开发账号
	 */
					
	private String kaifazhanghao;
	
	/**
	 * 开发姓名
	 */
					
	private String kaifaxingming;
	
	/**
	 * 测试账号
	 */
					
	private String ceshizhanghao;
	
	/**
	 * 测试姓名
	 */
					
	private String ceshixingming;
	
	/**
	 * 缺陷名称
	 */
					
	private String quexianmingcheng;
	
	/**
	 * 封面
	 */
					
	private String fengmian;
	
	/**
	 * 严重程度
	 */
					
	private String yanzhongchengdu;
	
	/**
	 * 状态
	 */
					
	private String zhuangtai;
	
	/**
	 * 缺陷描述
	 */
					
	private String quexianmiaoshu;
	
	
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
	 * 设置：开发账号
	 */
	public void setKaifazhanghao(String kaifazhanghao) {
		this.kaifazhanghao = kaifazhanghao;
	}
	/**
	 * 获取：开发账号
	 */
	public String getKaifazhanghao() {
		return kaifazhanghao;
	}
	/**
	 * 设置：开发姓名
	 */
	public void setKaifaxingming(String kaifaxingming) {
		this.kaifaxingming = kaifaxingming;
	}
	/**
	 * 获取：开发姓名
	 */
	public String getKaifaxingming() {
		return kaifaxingming;
	}
	/**
	 * 设置：测试账号
	 */
	public void setCeshizhanghao(String ceshizhanghao) {
		this.ceshizhanghao = ceshizhanghao;
	}
	/**
	 * 获取：测试账号
	 */
	public String getCeshizhanghao() {
		return ceshizhanghao;
	}
	/**
	 * 设置：测试姓名
	 */
	public void setCeshixingming(String ceshixingming) {
		this.ceshixingming = ceshixingming;
	}
	/**
	 * 获取：测试姓名
	 */
	public String getCeshixingming() {
		return ceshixingming;
	}
	/**
	 * 设置：缺陷名称
	 */
	public void setQuexianmingcheng(String quexianmingcheng) {
		this.quexianmingcheng = quexianmingcheng;
	}
	/**
	 * 获取：缺陷名称
	 */
	public String getQuexianmingcheng() {
		return quexianmingcheng;
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
	 * 设置：严重程度
	 */
	public void setYanzhongchengdu(String yanzhongchengdu) {
		this.yanzhongchengdu = yanzhongchengdu;
	}
	/**
	 * 获取：严重程度
	 */
	public String getYanzhongchengdu() {
		return yanzhongchengdu;
	}
	/**
	 * 设置：状态
	 */
	public void setZhuangtai(String zhuangtai) {
		this.zhuangtai = zhuangtai;
	}
	/**
	 * 获取：状态
	 */
	public String getZhuangtai() {
		return zhuangtai;
	}
	/**
	 * 设置：缺陷描述
	 */
	public void setQuexianmiaoshu(String quexianmiaoshu) {
		this.quexianmiaoshu = quexianmiaoshu;
	}
	/**
	 * 获取：缺陷描述
	 */
	public String getQuexianmiaoshu() {
		return quexianmiaoshu;
	}

}
