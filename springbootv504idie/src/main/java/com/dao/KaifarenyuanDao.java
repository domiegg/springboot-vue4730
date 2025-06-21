package com.dao;

import com.entity.KaifarenyuanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.KaifarenyuanVO;
import com.entity.view.KaifarenyuanView;


/**
 * 开发人员
 * 
 * @author 
 * @email 
 * @date 2024-05-06 16:46:56
 */
public interface KaifarenyuanDao extends BaseMapper<KaifarenyuanEntity> {
	
	List<KaifarenyuanVO> selectListVO(@Param("ew") Wrapper<KaifarenyuanEntity> wrapper);
	
	KaifarenyuanVO selectVO(@Param("ew") Wrapper<KaifarenyuanEntity> wrapper);
	
	List<KaifarenyuanView> selectListView(@Param("ew") Wrapper<KaifarenyuanEntity> wrapper);

	List<KaifarenyuanView> selectListView(Pagination page,@Param("ew") Wrapper<KaifarenyuanEntity> wrapper);

	
	KaifarenyuanView selectView(@Param("ew") Wrapper<KaifarenyuanEntity> wrapper);
	

}
