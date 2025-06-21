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


import com.dao.KaifarenyuanDao;
import com.entity.KaifarenyuanEntity;
import com.service.KaifarenyuanService;
import com.entity.vo.KaifarenyuanVO;
import com.entity.view.KaifarenyuanView;

@Service("kaifarenyuanService")
public class KaifarenyuanServiceImpl extends ServiceImpl<KaifarenyuanDao, KaifarenyuanEntity> implements KaifarenyuanService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<KaifarenyuanEntity> page = this.selectPage(
                new Query<KaifarenyuanEntity>(params).getPage(),
                new EntityWrapper<KaifarenyuanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<KaifarenyuanEntity> wrapper) {
		  Page<KaifarenyuanView> page =new Query<KaifarenyuanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<KaifarenyuanVO> selectListVO(Wrapper<KaifarenyuanEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public KaifarenyuanVO selectVO(Wrapper<KaifarenyuanEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<KaifarenyuanView> selectListView(Wrapper<KaifarenyuanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public KaifarenyuanView selectView(Wrapper<KaifarenyuanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
