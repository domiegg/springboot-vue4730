package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.CeshirenyuanEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.CeshirenyuanVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.CeshirenyuanView;


/**
 * 测试人员
 *
 * @author 
 * @email 
 * @date 2024-05-06 16:46:56
 */
public interface CeshirenyuanService extends IService<CeshirenyuanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<CeshirenyuanVO> selectListVO(Wrapper<CeshirenyuanEntity> wrapper);
   	
   	CeshirenyuanVO selectVO(@Param("ew") Wrapper<CeshirenyuanEntity> wrapper);
   	
   	List<CeshirenyuanView> selectListView(Wrapper<CeshirenyuanEntity> wrapper);
   	
   	CeshirenyuanView selectView(@Param("ew") Wrapper<CeshirenyuanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<CeshirenyuanEntity> wrapper);

   	

}

