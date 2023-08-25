package com.gulimall.product.controller;

import com.gulimall.common.utils.PageUtils;
import com.gulimall.common.utils.R;
import com.gulimall.product.entity.CategoryEntity;
import com.gulimall.product.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;



/**
 * 商品三级分类
 *
 * @author luosheep
 * @email luosheep2020@gmail.com
 * @date 2023-05-16 00:18:38
 */
@RestController
@RequestMapping("product/category")
public class CategoryController {
    @Resource
    private CategoryService categoryService;

    @RequestMapping("/list/tree")
    public R list(){

        List<CategoryEntity> entities=categoryService.listWithTree();
        return R.ok().put("data", entities);
    }
    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = categoryService.queryPage(params);
        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{catId}")
    public R info(@PathVariable("catId") Long catId){
		CategoryEntity category = categoryService.getById(catId);
        return R.ok().put("data", category);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody CategoryEntity category){
		categoryService.save(category);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody CategoryEntity category){
		categoryService.updateCascade(category);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] catIds){
        categoryService.removeMenuByIds(List.of(catIds));
        return R.ok();
    }

}
