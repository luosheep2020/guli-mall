package com.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gulimall.common.utils.PageUtils;
import com.gulimall.product.entity.UndoLogEntity;

import java.util.Map;

/**
 * 
 *
 * @author luosheep
 * @email luosheep2020@gmail.com
 * @date 2023-05-16 00:18:38
 */
public interface UndoLogService extends IService<UndoLogEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

