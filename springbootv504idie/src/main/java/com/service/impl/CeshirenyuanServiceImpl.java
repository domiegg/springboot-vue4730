package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.CeshirenyuanDao;
import com.entity.CeshirenyuanEntity;
import com.service.CeshirenyuanService;
import com.entity.vo.CeshirenyuanVO;
import com.entity.view.CeshirenyuanView;

@Service("ceshirenyuanService")
public class CeshirenyuanServiceImpl extends ServiceImpl<CeshirenyuanDao, CeshirenyuanEntity> implements CeshirenyuanService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CeshirenyuanEntity> page = this.selectPage(
                new Query<CeshirenyuanEntity>(params).getPage(),
                new EntityWrapper<CeshirenyuanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<CeshirenyuanEntity> wrapper) {
		  Page<CeshirenyuanView> page =new Query<CeshirenyuanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<CeshirenyuanVO> selectListVO(Wrapper<CeshirenyuanEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public CeshirenyuanVO selectVO(Wrapper<CeshirenyuanEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<CeshirenyuanView> selectListView(Wrapper<CeshirenyuanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public CeshirenyuanView selectView(Wrapper<CeshirenyuanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
