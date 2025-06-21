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

import com.entity.CeshirenyuanEntity;
import com.entity.view.CeshirenyuanView;

import com.service.CeshirenyuanService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 测试人员
 * 后端接口
 * @author 
 * @email 
 * @date 2024-05-06 16:46:56
 */
@RestController
@RequestMapping("/ceshirenyuan")
public class CeshirenyuanController {
    @Autowired
    private CeshirenyuanService ceshirenyuanService;




    
	@Autowired
	private TokenService tokenService;
	
	/**
	 * 登录
	 */
	@IgnoreAuth
	@RequestMapping(value = "/login")
	public R login(String username, String password, String captcha, HttpServletRequest request) {
		CeshirenyuanEntity u = ceshirenyuanService.selectOne(new EntityWrapper<CeshirenyuanEntity>().eq("ceshizhanghao", username));
		if(u==null || !u.getMima().equals(password)) {
			return R.error("账号或密码不正确");
		}
		
		String token = tokenService.generateToken(u.getId(), username,"ceshirenyuan",  "测试人员" );
		return R.ok().put("token", token);
	}


	
	/**
     * 注册
     */
	@IgnoreAuth
    @RequestMapping("/register")
    public R register(@RequestBody CeshirenyuanEntity ceshirenyuan){
    	//ValidatorUtils.validateEntity(ceshirenyuan);
    	CeshirenyuanEntity u = ceshirenyuanService.selectOne(new EntityWrapper<CeshirenyuanEntity>().eq("ceshizhanghao", ceshirenyuan.getCeshizhanghao()));
		if(u!=null) {
			return R.error("注册用户已存在");
		}
		Long uId = new Date().getTime();
		ceshirenyuan.setId(uId);
        ceshirenyuanService.insert(ceshirenyuan);
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
        CeshirenyuanEntity u = ceshirenyuanService.selectById(id);
        return R.ok().put("data", u);
    }
    
    /**
     * 密码重置
     */
    @IgnoreAuth
	@RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request){
    	CeshirenyuanEntity u = ceshirenyuanService.selectOne(new EntityWrapper<CeshirenyuanEntity>().eq("ceshizhanghao", username));
    	if(u==null) {
    		return R.error("账号不存在");
    	}
        u.setMima("123456");
        ceshirenyuanService.updateById(u);
        return R.ok("密码已重置为：123456");
    }



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,CeshirenyuanEntity ceshirenyuan,
		HttpServletRequest request){
        EntityWrapper<CeshirenyuanEntity> ew = new EntityWrapper<CeshirenyuanEntity>();

		PageUtils page = ceshirenyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, ceshirenyuan), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,CeshirenyuanEntity ceshirenyuan, 
		HttpServletRequest request){
        EntityWrapper<CeshirenyuanEntity> ew = new EntityWrapper<CeshirenyuanEntity>();

		PageUtils page = ceshirenyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, ceshirenyuan), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( CeshirenyuanEntity ceshirenyuan){
       	EntityWrapper<CeshirenyuanEntity> ew = new EntityWrapper<CeshirenyuanEntity>();
      	ew.allEq(MPUtil.allEQMapPre( ceshirenyuan, "ceshirenyuan")); 
        return R.ok().put("data", ceshirenyuanService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(CeshirenyuanEntity ceshirenyuan){
        EntityWrapper< CeshirenyuanEntity> ew = new EntityWrapper< CeshirenyuanEntity>();
 		ew.allEq(MPUtil.allEQMapPre( ceshirenyuan, "ceshirenyuan")); 
		CeshirenyuanView ceshirenyuanView =  ceshirenyuanService.selectView(ew);
		return R.ok("查询测试人员成功").put("data", ceshirenyuanView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        CeshirenyuanEntity ceshirenyuan = ceshirenyuanService.selectById(id);
        return R.ok().put("data", ceshirenyuan);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        CeshirenyuanEntity ceshirenyuan = ceshirenyuanService.selectById(id);
        return R.ok().put("data", ceshirenyuan);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody CeshirenyuanEntity ceshirenyuan, HttpServletRequest request){
        if(ceshirenyuanService.selectCount(new EntityWrapper<CeshirenyuanEntity>().eq("ceshizhanghao", ceshirenyuan.getCeshizhanghao()))>0) {
            return R.error("测试账号已存在");
        }
    	ceshirenyuan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(ceshirenyuan);
    	CeshirenyuanEntity u = ceshirenyuanService.selectOne(new EntityWrapper<CeshirenyuanEntity>().eq("ceshizhanghao", ceshirenyuan.getCeshizhanghao()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		ceshirenyuan.setId(new Date().getTime());
        ceshirenyuanService.insert(ceshirenyuan);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody CeshirenyuanEntity ceshirenyuan, HttpServletRequest request){
        if(ceshirenyuanService.selectCount(new EntityWrapper<CeshirenyuanEntity>().eq("ceshizhanghao", ceshirenyuan.getCeshizhanghao()))>0) {
            return R.error("测试账号已存在");
        }
    	ceshirenyuan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(ceshirenyuan);
    	CeshirenyuanEntity u = ceshirenyuanService.selectOne(new EntityWrapper<CeshirenyuanEntity>().eq("ceshizhanghao", ceshirenyuan.getCeshizhanghao()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		ceshirenyuan.setId(new Date().getTime());
        ceshirenyuanService.insert(ceshirenyuan);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody CeshirenyuanEntity ceshirenyuan, HttpServletRequest request){
        //ValidatorUtils.validateEntity(ceshirenyuan);
        if(ceshirenyuanService.selectCount(new EntityWrapper<CeshirenyuanEntity>().ne("id", ceshirenyuan.getId()).eq("ceshizhanghao", ceshirenyuan.getCeshizhanghao()))>0) {
            return R.error("测试账号已存在");
        }
        ceshirenyuanService.updateById(ceshirenyuan);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        ceshirenyuanService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
