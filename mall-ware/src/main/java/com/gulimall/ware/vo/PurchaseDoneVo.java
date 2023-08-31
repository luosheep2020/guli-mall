package com.gulimall.ware.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class PurchaseDoneVo {
    @NotNull
    private Long id;
    private List<PurchaseItemDoneVo> items;
}
