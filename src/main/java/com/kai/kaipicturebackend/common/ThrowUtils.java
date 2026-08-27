package com.kai.kaipicturebackend.common;

import com.kai.kaipicturebackend.exception.BusinessException;

/**
 * 抛异常工具类 —— 让"条件不满足就抛异常"的代码更简洁。
 *
 * 用法（第 4 期会大量用到）：
 * ThrowUtils.throwIf(StrUtil.isBlank(name), ErrorCode.PARAMS_ERROR, "名称不能为空");
 *
 * 第 3 期任务：理解它和下面写法等价：
 * if (条件) { throw new BusinessException(错误码, 信息); }
 */
public class ThrowUtils {

    /**
     * 条件成立则抛业务异常
     */
    public static void throwIf(boolean condition, RuntimeException runtimeException) {
        if (condition) {
            throw runtimeException;
        }
    }

    /**
     * 条件成立则抛业务异常（按错误码）
     */
    public static void throwIf(boolean condition, ErrorCode errorCode) {
        throwIf(condition, new BusinessException(errorCode));
    }

    /**
     * 条件成立则抛业务异常（错误码 + 自定义信息）
     */
    public static void throwIf(boolean condition, ErrorCode errorCode, String message) {
        throwIf(condition, new BusinessException(errorCode, message));
    }
}
