package com.gulimall.ware.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseItemDoneVo {

    private Long itemId;
    private Integer status;
    private String reason;
}
