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


import com.dao.QuexianxinxiDao;
import com.entity.QuexianxinxiEntity;
import com.service.QuexianxinxiService;
import com.entity.vo.QuexianxinxiVO;
import com.entity.view.QuexianxinxiView;

@Service("quexianxinxiService")
public class QuexianxinxiServiceImpl extends ServiceImpl<QuexianxinxiDao, QuexianxinxiEntity> implements QuexianxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<QuexianxinxiEntity> page = this.selectPage(
                new Query<QuexianxinxiEntity>(params).getPage(),
                new EntityWrapper<QuexianxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<QuexianxinxiEntity> wrapper) {
		  Page<QuexianxinxiView> page =new Query<QuexianxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<QuexianxinxiVO> selectListVO(Wrapper<QuexianxinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public QuexianxinxiVO selectVO(Wrapper<QuexianxinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<QuexianxinxiView> selectListView(Wrapper<QuexianxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public QuexianxinxiView selectView(Wrapper<QuexianxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<QuexianxinxiEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<QuexianxinxiEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<QuexianxinxiEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }




}
