package com.gulimall.member.controller;

import com.gulimall.common.utils.PageUtils;
import com.gulimall.common.utils.R;
import com.gulimall.member.entity.MemberEntity;
import com.gulimall.member.feign.CouponFeignService;
import com.gulimall.member.service.MemberService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Map;


/**
 * 会员
 *
 * @author luosheep
 * @email luosheep@gmail.com
 * @date 2023-05-10 01:20:18
 */
@RestController
@RequestMapping("member/member")
public class MemberController {
    @Resource
    private MemberService memberService;

    @Resource
    CouponFeignService couponFeignService;
    @RequestMapping("/coupons")
    public R test(){
        MemberEntity member=new MemberEntity();
        member.setNickname("徐嘉龙");
        R memberCoupons = couponFeignService.memberCoupons();
        return R.ok().put("member",member).put("coupon",memberCoupons.get("coupons"));
    }
    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = memberService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		MemberEntity member = memberService.getById(id);

        return R.ok().put("member", member);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody MemberEntity member){
		memberService.save(member);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody MemberEntity member){
		memberService.updateById(member);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		memberService.removeByIds(Arrays.asList(ids));
        return R.ok();
    }

}
