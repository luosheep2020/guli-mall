package com.gulimall.product.vo;
import com.gulimall.product.entity.AttrEntity;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class SpuItemAttrGroupVo {
    private String groupName;
    private List<AttrEntity> attrs;
}
