package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.QuexianxinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.QuexianxinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.QuexianxinxiView;


/**
 * 缺陷信息
 *
 * @author 
 * @email 
 * @date 2024-05-06 16:46:57
 */
public interface QuexianxinxiService extends IService<QuexianxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<QuexianxinxiVO> selectListVO(Wrapper<QuexianxinxiEntity> wrapper);
   	
   	QuexianxinxiVO selectVO(@Param("ew") Wrapper<QuexianxinxiEntity> wrapper);
   	
   	List<QuexianxinxiView> selectListView(Wrapper<QuexianxinxiEntity> wrapper);
   	
   	QuexianxinxiView selectView(@Param("ew") Wrapper<QuexianxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<QuexianxinxiEntity> wrapper);

   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<QuexianxinxiEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<QuexianxinxiEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<QuexianxinxiEntity> wrapper);



}

