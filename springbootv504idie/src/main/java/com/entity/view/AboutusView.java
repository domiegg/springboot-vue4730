package com.entity.view;

import com.entity.AboutusEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 关于我们
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-05-06 16:46:57
 */
@TableName("aboutus")
public class AboutusView  extends AboutusEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public AboutusView(){
	}
 
 	public AboutusView(AboutusEntity aboutusEntity){
 	try {
			BeanUtils.copyProperties(this, aboutusEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
