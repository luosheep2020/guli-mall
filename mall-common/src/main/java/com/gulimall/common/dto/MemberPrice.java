package com.gulimall.common.dto;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class MemberPrice {

    private Long id;
    private String name;
    private BigDecimal price;

}
