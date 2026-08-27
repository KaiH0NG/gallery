package com.kai.kaipicturebackend.exception;

import com.kai.kaipicturebackend.common.ErrorCode;
import lombok.Getter;

/**
 * 业务异常 —— 业务逻辑出错时抛出（比如"账号已存在"、"无权限"）。
 *
 * 第 3 期任务：
 * 1. 理解为什么自定义异常而不是直接返回 null（异常能中断流程、统一处理）
 * 2. 抛出后谁来接？→ 看 GlobalExceptionHandler
 */
@Getter
public class BusinessException extends RuntimeException {

    /**
     * 错误码
     */
    private final int code;

    public BusinessException(int code, String message) {
        super(message);
        this.code = code;
    }

    public BusinessException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.code = errorCode.getCode();
    }

    public BusinessException(ErrorCode errorCode, String message) {
        super(message);
        this.code = errorCode.getCode();
    }
}
