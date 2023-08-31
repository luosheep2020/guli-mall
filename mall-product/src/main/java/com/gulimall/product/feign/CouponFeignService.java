package com.gulimall.product.feign;

import com.gulimall.common.dto.SkuReductionDto;
import com.gulimall.common.dto.SpuBoundDto;
import com.gulimall.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("mall-coupon")
public interface CouponFeignService {
    @PostMapping("/coupon/spubounds/save")
    R saveSpuBounds(@RequestBody SpuBoundDto spuBoundDto);

    @PostMapping("/coupon/skufullreduction/saveinfo")
    void saveSkuReduction(@RequestBody SkuReductionDto skuReductionDto);
}
