package com.gulimall.coupon.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gulimall.common.dto.MemberPrice;
import com.gulimall.common.dto.SkuReductionDto;
import com.gulimall.common.utils.PageUtils;
import com.gulimall.common.utils.Query;
import com.gulimall.coupon.dao.SkuFullReductionDao;
import com.gulimall.coupon.entity.MemberPriceEntity;
import com.gulimall.coupon.entity.SkuFullReductionEntity;
import com.gulimall.coupon.entity.SkuLadderEntity;
import com.gulimall.coupon.service.MemberPriceService;
import com.gulimall.coupon.service.SkuFullReductionService;
import com.gulimall.coupon.service.SkuLadderService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service("skuFullReductionService")
public class SkuFullReductionServiceImpl extends ServiceImpl<SkuFullReductionDao, SkuFullReductionEntity> implements SkuFullReductionService {
    @Resource
    private SkuLadderService skuLadderService;
    @Resource
    private MemberPriceService memberPriceService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SkuFullReductionEntity> page = this.page(
                new Query<SkuFullReductionEntity>().getPage(params),
                new QueryWrapper<SkuFullReductionEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public void saveSkuReduction(SkuReductionDto skuReductionDto) {
        SkuLadderEntity skuLadderEntity = new SkuLadderEntity();
        skuLadderEntity.setSkuId(skuReductionDto.getSkuId());
        skuLadderEntity.setFullCount(skuReductionDto.getFullCount());
        skuLadderEntity.setDiscount(skuReductionDto.getDiscount());
        skuLadderEntity.setAddOther(skuReductionDto.getCountStatus());
        if (skuReductionDto.getFullCount() > 0) {
            skuLadderService.save(skuLadderEntity);
        }


        SkuFullReductionEntity reductionEntity = new SkuFullReductionEntity();
        BeanUtils.copyProperties(skuReductionDto, reductionEntity);
        if (reductionEntity.getFullPrice().compareTo(new BigDecimal(0)) == 1) {
            this.save(reductionEntity);
        }


        List<MemberPrice> memberPrice = skuReductionDto.getMemberPrice();
        List<MemberPriceEntity> collect = memberPrice.stream().map(item -> {
            MemberPriceEntity memberPriceEntity = new MemberPriceEntity();

            memberPriceEntity.setSkuId(skuReductionDto.getSkuId());
            memberPriceEntity.setMemberLevelId(item.getId());
            memberPriceEntity.setMemberLevelName(item.getName());
            memberPriceEntity.setMemberPrice(item.getPrice());
            memberPriceEntity.setAddOther(1);
            return memberPriceEntity;
        }).filter(item->{
            return item.getMemberPrice().compareTo(new BigDecimal("0"))==1;
        }).collect(Collectors.toList());
        memberPriceService.saveBatch(collect);
    }

}
