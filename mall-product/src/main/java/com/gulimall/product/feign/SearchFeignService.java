package com.gulimall.product.feign;

import com.gulimall.common.dto.es.SkuEsModel;
import com.gulimall.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient("mall-search")
public interface SearchFeignService {
    @PostMapping("/search/save/product")
    public R productStatusUp(List<SkuEsModel> skuEsModels);
}
