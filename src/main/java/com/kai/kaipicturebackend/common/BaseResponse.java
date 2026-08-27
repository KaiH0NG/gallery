package com.kai.kaipicturebackend.common;

import lombok.Data;

import java.io.Serializable;

/**
 * 统一响应结构 —— 所有接口都返回这个格式。
 *
 * 为什么需要统一？：
 * 1. 前端只需解析一种结构，不用每个接口特殊处理
 * 2. 错误信息统一，前端拦截器可以统一弹提示
 * 3. 结构：{ code: 状态码, data: 业务数据, message: 提示信息 }
 *
 * 第 3 期任务：理解三个构造方法分别在什么场景用
 * - 成功：new BaseResponse<>(0, data, "ok")
 * - 失败：new BaseResponse<>(errorCode.getCode(), null, errorCode.getMessage())
 */
@Data
public class BaseResponse<T> implements Serializable {

    /**
     * 状态码（0 成功，其他为错误码，见 ErrorCode）
     */
    private int code;

    /**
     * 业务数据
     */
    private T data;

    /**
     * 提示信息
     */
    private String message;

    public BaseResponse(int code, T data, String message) {
        this.code = code;
        this.data = data;
        this.message = message;
    }

    public BaseResponse(int code, T data) {
        this(code, data, "");
    }

    public BaseResponse(ErrorCode errorCode) {
        this(errorCode.getCode(), null, errorCode.getMessage());
    }
}
