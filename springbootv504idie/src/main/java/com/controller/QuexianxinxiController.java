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

import com.entity.QuexianxinxiEntity;
import com.entity.view.QuexianxinxiView;

import com.service.QuexianxinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 缺陷信息
 * 后端接口
 * @author 
 * @email 
 * @date 2024-05-06 16:46:57
 */
@RestController
@RequestMapping("/quexianxinxi")
public class QuexianxinxiController {
    @Autowired
    private QuexianxinxiService quexianxinxiService;




    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,QuexianxinxiEntity quexianxinxi,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("kaifarenyuan")) {
			quexianxinxi.setKaifazhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("ceshirenyuan")) {
			quexianxinxi.setCeshizhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<QuexianxinxiEntity> ew = new EntityWrapper<QuexianxinxiEntity>();

		PageUtils page = quexianxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, quexianxinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,QuexianxinxiEntity quexianxinxi, 
		HttpServletRequest request){
        EntityWrapper<QuexianxinxiEntity> ew = new EntityWrapper<QuexianxinxiEntity>();

		PageUtils page = quexianxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, quexianxinxi), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( QuexianxinxiEntity quexianxinxi){
       	EntityWrapper<QuexianxinxiEntity> ew = new EntityWrapper<QuexianxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( quexianxinxi, "quexianxinxi")); 
        return R.ok().put("data", quexianxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(QuexianxinxiEntity quexianxinxi){
        EntityWrapper< QuexianxinxiEntity> ew = new EntityWrapper< QuexianxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( quexianxinxi, "quexianxinxi")); 
		QuexianxinxiView quexianxinxiView =  quexianxinxiService.selectView(ew);
		return R.ok("查询缺陷信息成功").put("data", quexianxinxiView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        QuexianxinxiEntity quexianxinxi = quexianxinxiService.selectById(id);
        return R.ok().put("data", quexianxinxi);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        QuexianxinxiEntity quexianxinxi = quexianxinxiService.selectById(id);
        return R.ok().put("data", quexianxinxi);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody QuexianxinxiEntity quexianxinxi, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(quexianxinxi);
        quexianxinxiService.insert(quexianxinxi);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody QuexianxinxiEntity quexianxinxi, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(quexianxinxi);
        quexianxinxiService.insert(quexianxinxi);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody QuexianxinxiEntity quexianxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(quexianxinxi);
        quexianxinxiService.updateById(quexianxinxi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        quexianxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	






    /**
     * （按值统计）
     */
    @RequestMapping("/value/{xColumnName}/{yColumnName}")
    public R value(@PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        EntityWrapper<QuexianxinxiEntity> ew = new EntityWrapper<QuexianxinxiEntity>();
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("kaifarenyuan")) {
            ew.eq("kaifazhanghao", (String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("ceshirenyuan")) {
            ew.eq("ceshizhanghao", (String)request.getSession().getAttribute("username"));
		}
        List<Map<String, Object>> result = quexianxinxiService.selectValue(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }

    /**
     * （按值统计(多)）
     */
    @RequestMapping("/valueMul/{xColumnName}")
    public R valueMul(@PathVariable("xColumnName") String xColumnName,@RequestParam String yColumnNameMul, HttpServletRequest request) {
        String[] yColumnNames = yColumnNameMul.split(",");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        List<List<Map<String, Object>>> result2 = new ArrayList<List<Map<String,Object>>>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        EntityWrapper<QuexianxinxiEntity> ew = new EntityWrapper<QuexianxinxiEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("kaifarenyuan")) {
            ew.eq("kaifazhanghao", (String)request.getSession().getAttribute("username"));
        }
        if(tableName.equals("ceshirenyuan")) {
            ew.eq("ceshizhanghao", (String)request.getSession().getAttribute("username"));
        }
        for(int i=0;i<yColumnNames.length;i++) {
            params.put("yColumn", yColumnNames[i]);
            List<Map<String, Object>> result = quexianxinxiService.selectValue(params, ew);
            for(Map<String, Object> m : result) {
                for(String k : m.keySet()) {
                    if(m.get(k) instanceof Date) {
                        m.put(k, sdf.format((Date)m.get(k)));
                    }
                }
            }
            result2.add(result);
        }
        return R.ok().put("data", result2);
    }

    /**
     * （按值统计）时间统计类型
     */
    @RequestMapping("/value/{xColumnName}/{yColumnName}/{timeStatType}")
    public R valueDay(@PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName, @PathVariable("timeStatType") String timeStatType,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        params.put("timeStatType", timeStatType);
        EntityWrapper<QuexianxinxiEntity> ew = new EntityWrapper<QuexianxinxiEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("kaifarenyuan")) {
            ew.eq("kaifazhanghao", (String)request.getSession().getAttribute("username"));
        }
        if(tableName.equals("ceshirenyuan")) {
            ew.eq("ceshizhanghao", (String)request.getSession().getAttribute("username"));
        }
        List<Map<String, Object>> result = quexianxinxiService.selectTimeStatValue(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }

    /**
     * （按值统计）时间统计类型(多)
     */
    @RequestMapping("/valueMul/{xColumnName}/{timeStatType}")
    public R valueMulDay(@PathVariable("xColumnName") String xColumnName, @PathVariable("timeStatType") String timeStatType,@RequestParam String yColumnNameMul,HttpServletRequest request) {
        String[] yColumnNames = yColumnNameMul.split(",");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("timeStatType", timeStatType);
        List<List<Map<String, Object>>> result2 = new ArrayList<List<Map<String,Object>>>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        EntityWrapper<QuexianxinxiEntity> ew = new EntityWrapper<QuexianxinxiEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("kaifarenyuan")) {
            ew.eq("kaifazhanghao", (String)request.getSession().getAttribute("username"));
        }
        if(tableName.equals("ceshirenyuan")) {
            ew.eq("ceshizhanghao", (String)request.getSession().getAttribute("username"));
        }
        for(int i=0;i<yColumnNames.length;i++) {
            params.put("yColumn", yColumnNames[i]);
            List<Map<String, Object>> result = quexianxinxiService.selectTimeStatValue(params, ew);
            for(Map<String, Object> m : result) {
                for(String k : m.keySet()) {
                    if(m.get(k) instanceof Date) {
                        m.put(k, sdf.format((Date)m.get(k)));
                    }
                }
            }
            result2.add(result);
        }
        return R.ok().put("data", result2);
    }

    /**
     * 分组统计
     */
    @RequestMapping("/group/{columnName}")
    public R group(@PathVariable("columnName") String columnName,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("column", columnName);
        EntityWrapper<QuexianxinxiEntity> ew = new EntityWrapper<QuexianxinxiEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("kaifarenyuan")) {
            ew.eq("kaifazhanghao", (String)request.getSession().getAttribute("username"));
        }
        if(tableName.equals("ceshirenyuan")) {
            ew.eq("ceshizhanghao", (String)request.getSession().getAttribute("username"));
        }
        List<Map<String, Object>> result = quexianxinxiService.selectGroup(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }




    /**
     * 总数量
     */
    @RequestMapping("/count")
    public R count(@RequestParam Map<String, Object> params,QuexianxinxiEntity quexianxinxi, HttpServletRequest request){
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("kaifarenyuan")) {
            quexianxinxi.setKaifazhanghao((String)request.getSession().getAttribute("username"));
        }
        if(tableName.equals("ceshirenyuan")) {
            quexianxinxi.setCeshizhanghao((String)request.getSession().getAttribute("username"));
        }
        EntityWrapper<QuexianxinxiEntity> ew = new EntityWrapper<QuexianxinxiEntity>();
        int count = quexianxinxiService.selectCount(MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, quexianxinxi), params), params));
        return R.ok().put("data", count);
    }



}
