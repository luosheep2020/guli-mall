package com.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gulimall.common.utils.PageUtils;
import com.gulimall.product.entity.AttrEntity;
import com.gulimall.product.vo.AtrrVo;
import com.gulimall.product.vo.AttrGroupRelationVo;
import com.gulimall.product.vo.AttrRespVo;

import java.util.List;
import java.util.Map;

/**
 * 商品属性
 *
 * @author luosheep
 * @email luosheep2020@gmail.com
 * @date 2023-05-16 00:18:38
 */
public interface AttrService extends IService<AttrEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void saveAttr(AtrrVo attr);

    PageUtils queryBaseAttrPage(Map<String, Object> params, Long catelogId, String attrType);

    AttrRespVo getAttrInfo(Long attrId);

    void updateAttr(AtrrVo attr);

    List<AttrEntity> getRelationAttr(Long attrgroupId);

    void deleteRelation(AttrGroupRelationVo[] attrIds);

    PageUtils getNoRelationAttr(Map<String, Object> params, Long attrgroupId);
}

