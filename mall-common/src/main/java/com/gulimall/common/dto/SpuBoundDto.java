package com.gulimall.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class SpuBoundDto {
    private Long spuId;
    private BigDecimal buyBounds;
    private BigDecimal growBounds;
}
