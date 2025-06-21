package com.dao;

import com.entity.CeshirenyuanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.CeshirenyuanVO;
import com.entity.view.CeshirenyuanView;


/**
 * 测试人员
 * 
 * @author 
 * @email 
 * @date 2024-05-06 16:46:56
 */
public interface CeshirenyuanDao extends BaseMapper<CeshirenyuanEntity> {
	
	List<CeshirenyuanVO> selectListVO(@Param("ew") Wrapper<CeshirenyuanEntity> wrapper);
	
	CeshirenyuanVO selectVO(@Param("ew") Wrapper<CeshirenyuanEntity> wrapper);
	
	List<CeshirenyuanView> selectListView(@Param("ew") Wrapper<CeshirenyuanEntity> wrapper);

	List<CeshirenyuanView> selectListView(Pagination page,@Param("ew") Wrapper<CeshirenyuanEntity> wrapper);

	
	CeshirenyuanView selectView(@Param("ew") Wrapper<CeshirenyuanEntity> wrapper);
	

}
