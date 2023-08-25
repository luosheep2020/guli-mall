package com.gulimall.product;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gulimall.product.entity.BrandEntity;
import com.gulimall.product.service.BrandService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class MallProductApplicationTests {
    @Resource
    BrandService brandService;
    @Test
    void contextLoads() {
        List<BrandEntity> list = brandService.list(new QueryWrapper<BrandEntity>().eq("brand_id", 1));
        list.forEach(System.out::println);
    }

}
