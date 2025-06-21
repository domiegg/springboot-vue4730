package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.KaifarenyuanEntity;
import com.entity.view.KaifarenyuanView;

import com.service.KaifarenyuanService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 开发人员
 * 后端接口
 * @author 
 * @email 
 * @date 2024-05-06 16:46:56
 */
@RestController
@RequestMapping("/kaifarenyuan")
public class KaifarenyuanController {
    @Autowired
    private KaifarenyuanService kaifarenyuanService;




    
	@Autowired
	private TokenService tokenService;
	
	/**
	 * 登录
	 */
	@IgnoreAuth
	@RequestMapping(value = "/login")
	public R login(String username, String password, String captcha, HttpServletRequest request) {
		KaifarenyuanEntity u = kaifarenyuanService.selectOne(new EntityWrapper<KaifarenyuanEntity>().eq("kaifazhanghao", username));
		if(u==null || !u.getMima().equals(password)) {
			return R.error("账号或密码不正确");
		}
		
		String token = tokenService.generateToken(u.getId(), username,"kaifarenyuan",  "开发人员" );
		return R.ok().put("token", token);
	}


	
	/**
     * 注册
     */
	@IgnoreAuth
    @RequestMapping("/register")
    public R register(@RequestBody KaifarenyuanEntity kaifarenyuan){
    	//ValidatorUtils.validateEntity(kaifarenyuan);
    	KaifarenyuanEntity u = kaifarenyuanService.selectOne(new EntityWrapper<KaifarenyuanEntity>().eq("kaifazhanghao", kaifarenyuan.getKaifazhanghao()));
		if(u!=null) {
			return R.error("注册用户已存在");
		}
		Long uId = new Date().getTime();
		kaifarenyuan.setId(uId);
        kaifarenyuanService.insert(kaifarenyuan);
        return R.ok();
    }

	
	/**
	 * 退出
	 */
	@RequestMapping("/logout")
	public R logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return R.ok("退出成功");
	}
	
	/**
     * 获取用户的session用户信息
     */
    @RequestMapping("/session")
    public R getCurrUser(HttpServletRequest request){
    	Long id = (Long)request.getSession().getAttribute("userId");
        KaifarenyuanEntity u = kaifarenyuanService.selectById(id);
        return R.ok().put("data", u);
    }
    
    /**
     * 密码重置
     */
    @IgnoreAuth
	@RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request){
    	KaifarenyuanEntity u = kaifarenyuanService.selectOne(new EntityWrapper<KaifarenyuanEntity>().eq("kaifazhanghao", username));
    	if(u==null) {
    		return R.error("账号不存在");
    	}
        u.setMima("123456");
        kaifarenyuanService.updateById(u);
        return R.ok("密码已重置为：123456");
    }



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,KaifarenyuanEntity kaifarenyuan,
		HttpServletRequest request){
        EntityWrapper<KaifarenyuanEntity> ew = new EntityWrapper<KaifarenyuanEntity>();

		PageUtils page = kaifarenyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, kaifarenyuan), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,KaifarenyuanEntity kaifarenyuan, 
		HttpServletRequest request){
        EntityWrapper<KaifarenyuanEntity> ew = new EntityWrapper<KaifarenyuanEntity>();

		PageUtils page = kaifarenyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, kaifarenyuan), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( KaifarenyuanEntity kaifarenyuan){
       	EntityWrapper<KaifarenyuanEntity> ew = new EntityWrapper<KaifarenyuanEntity>();
      	ew.allEq(MPUtil.allEQMapPre( kaifarenyuan, "kaifarenyuan")); 
        return R.ok().put("data", kaifarenyuanService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(KaifarenyuanEntity kaifarenyuan){
        EntityWrapper< KaifarenyuanEntity> ew = new EntityWrapper< KaifarenyuanEntity>();
 		ew.allEq(MPUtil.allEQMapPre( kaifarenyuan, "kaifarenyuan")); 
		KaifarenyuanView kaifarenyuanView =  kaifarenyuanService.selectView(ew);
		return R.ok("查询开发人员成功").put("data", kaifarenyuanView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        KaifarenyuanEntity kaifarenyuan = kaifarenyuanService.selectById(id);
        return R.ok().put("data", kaifarenyuan);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        KaifarenyuanEntity kaifarenyuan = kaifarenyuanService.selectById(id);
        return R.ok().put("data", kaifarenyuan);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody KaifarenyuanEntity kaifarenyuan, HttpServletRequest request){
        if(kaifarenyuanService.selectCount(new EntityWrapper<KaifarenyuanEntity>().eq("kaifazhanghao", kaifarenyuan.getKaifazhanghao()))>0) {
            return R.error("开发账号已存在");
        }
    	kaifarenyuan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(kaifarenyuan);
    	KaifarenyuanEntity u = kaifarenyuanService.selectOne(new EntityWrapper<KaifarenyuanEntity>().eq("kaifazhanghao", kaifarenyuan.getKaifazhanghao()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		kaifarenyuan.setId(new Date().getTime());
        kaifarenyuanService.insert(kaifarenyuan);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody KaifarenyuanEntity kaifarenyuan, HttpServletRequest request){
        if(kaifarenyuanService.selectCount(new EntityWrapper<KaifarenyuanEntity>().eq("kaifazhanghao", kaifarenyuan.getKaifazhanghao()))>0) {
            return R.error("开发账号已存在");
        }
    	kaifarenyuan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(kaifarenyuan);
    	KaifarenyuanEntity u = kaifarenyuanService.selectOne(new EntityWrapper<KaifarenyuanEntity>().eq("kaifazhanghao", kaifarenyuan.getKaifazhanghao()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		kaifarenyuan.setId(new Date().getTime());
        kaifarenyuanService.insert(kaifarenyuan);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody KaifarenyuanEntity kaifarenyuan, HttpServletRequest request){
        //ValidatorUtils.validateEntity(kaifarenyuan);
        if(kaifarenyuanService.selectCount(new EntityWrapper<KaifarenyuanEntity>().ne("id", kaifarenyuan.getId()).eq("kaifazhanghao", kaifarenyuan.getKaifazhanghao()))>0) {
            return R.error("开发账号已存在");
        }
        kaifarenyuanService.updateById(kaifarenyuan);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        kaifarenyuanService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
