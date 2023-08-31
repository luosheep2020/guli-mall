package com.gulimall.common.exception;

/**
 * 令牌处理异常
 */
public class TokenException extends RuntimeException {

    public TokenException() {
        super("处理token，返回错误信息时异常");
    }
}
