package com.gulimall.common.exception;

/**
 * 订单验价异常

 */
public class VerifyPriceException extends RuntimeException {

    public VerifyPriceException() {
        super("订单商品价格发生变化，请确认后再次提交");
    }

}
