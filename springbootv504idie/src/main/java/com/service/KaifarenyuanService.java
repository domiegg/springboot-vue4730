package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.KaifarenyuanEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.KaifarenyuanVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.KaifarenyuanView;


/**
 * 开发人员
 *
 * @author 
 * @email 
 * @date 2024-05-06 16:46:56
 */
public interface KaifarenyuanService extends IService<KaifarenyuanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<KaifarenyuanVO> selectListVO(Wrapper<KaifarenyuanEntity> wrapper);
   	
   	KaifarenyuanVO selectVO(@Param("ew") Wrapper<KaifarenyuanEntity> wrapper);
   	
   	List<KaifarenyuanView> selectListView(Wrapper<KaifarenyuanEntity> wrapper);
   	
   	KaifarenyuanView selectView(@Param("ew") Wrapper<KaifarenyuanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<KaifarenyuanEntity> wrapper);

   	

}

