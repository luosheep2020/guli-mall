package com.gulimall.ware.dao;

import com.gulimall.ware.entity.WareSkuEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品库存
 * 
 * @author luosheep
 * @email luosheep@gmail.com
 * @date 2023-05-10 01:32:16
 */
@Mapper
public interface WareSkuDao extends BaseMapper<WareSkuEntity> {
	
}
