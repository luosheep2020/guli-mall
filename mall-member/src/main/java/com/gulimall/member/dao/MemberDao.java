package com.gulimall.member.dao;

import com.gulimall.member.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 * 
 * @author luosheep
 * @email luosheep@gmail.com
 * @date 2023-05-10 01:20:18
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}
