package com.entity.view;

import com.entity.KaifarenyuanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 开发人员
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-05-06 16:46:56
 */
@TableName("kaifarenyuan")
public class KaifarenyuanView  extends KaifarenyuanEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public KaifarenyuanView(){
	}
 
 	public KaifarenyuanView(KaifarenyuanEntity kaifarenyuanEntity){
 	try {
			BeanUtils.copyProperties(this, kaifarenyuanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
