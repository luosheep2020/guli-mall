package com.gulimall.product.controller;

import java.util.Arrays;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gulimall.product.entity.UndoLogEntity;
import com.gulimall.product.service.UndoLogService;
import com.gulimall.common.utils.PageUtils;
import com.gulimall.common.utils.R;



/**
 * 
 *
 * @author luosheep
 * @email luosheep2020@gmail.com
 * @date 2023-05-16 00:18:38
 */
@RestController
@RequestMapping("product/undolog")
public class UndoLogController {
    @Resource
    private UndoLogService undoLogService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = undoLogService.queryPage(params);
        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		UndoLogEntity undoLog = undoLogService.getById(id);
        return R.ok().put("undoLog", undoLog);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody UndoLogEntity undoLog){
		undoLogService.save(undoLog);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody UndoLogEntity undoLog){
		undoLogService.updateById(undoLog);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		undoLogService.removeByIds(Arrays.asList(ids));
        return R.ok();
    }

}