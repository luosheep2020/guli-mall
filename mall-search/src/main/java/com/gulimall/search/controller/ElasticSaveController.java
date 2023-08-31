package com.gulimall.search.controller;

import com.gulimall.common.dto.es.SkuEsModel;
import com.gulimall.common.exception.BizCodeEnume;
import com.gulimall.common.utils.R;
import com.gulimall.search.service.ProductSaveService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

@Slf4j
@RequestMapping("/search/save")
@RestController
public class ElasticSaveController {
    @Resource
    private ProductSaveService productSaveService;

    @PostMapping("/product")
    public R productStatusUp(List<SkuEsModel> skuEsModels) {
        boolean result = false;// 是否执行成功
        try {
            result = productSaveService.productStatusUp(skuEsModels);
        } catch (IOException e) {
            log.error("ElasticSaveController商品上架错误：{}", e);
            return R.error(BizCodeEnume.PRODUCT_UP_EXCEPTION.getCode(), BizCodeEnume.PRODUCT_UP_EXCEPTION.getMsg());
        }
        if (result) {
            return R.ok();// 执行成功
        } else {
            return R.error(BizCodeEnume.PRODUCT_UP_EXCEPTION.getCode(), BizCodeEnume.PRODUCT_UP_EXCEPTION.getMsg());
        }
    }
}
