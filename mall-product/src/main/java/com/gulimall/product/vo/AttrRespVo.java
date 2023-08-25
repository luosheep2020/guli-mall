package com.gulimall.product.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AttrRespVo extends AtrrVo{
    private String catelogName;
    private String groupName;
    private Long[] catelogPath;
}
