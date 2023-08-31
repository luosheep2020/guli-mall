package com.gulimall.product.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gulimall.product.entity.AttrEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 商品属性
 *
 * @author luosheep
 * @email luosheep2020@gmail.com
 * @date 2023-05-16 00:18:38
 */
@Mapper
public interface AttrDao extends BaseMapper<AttrEntity> {


    List<Long> selectSearchAttrs(@Param("attrIds") List<Long> attrIds);
}
