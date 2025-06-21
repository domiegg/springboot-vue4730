package com.entity.model;

import com.entity.QuexianxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 缺陷信息
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2024-05-06 16:46:57
 */
public class QuexianxinxiModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
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
