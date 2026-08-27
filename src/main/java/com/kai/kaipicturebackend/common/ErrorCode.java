package com.kai.kaipicturebackend.common;

/**
 * 错误码枚举 —— 集中管理所有错误码，禁止魔法数字。
 *
 * 设计规范（面试点）：
 * - code 是给前端/程序判断用的，message 是给用户看的
 * - 错误码分段：4xxxx 客户端问题，5xxxx 服务端问题
 *
 * 第 3 期任务：后续开发中遇到新的错误场景，先来这里加枚举
 * 第 5 期任务：图片操作失败时，可用 OPERATION_ERROR
 */
public enum ErrorCode {

    SUCCESS(0, "ok"),
    PARAMS_ERROR(40000, "请求参数错误"),
    NOT_LOGIN_ERROR(40100, "未登录"),
    NO_AUTH_ERROR(40101, "无权限"),
    NOT_FOUND_ERROR(40400, "请求数据不存在"),
    FORBIDDEN_ERROR(40300, "禁止访问"),
    SYSTEM_ERROR(50000, "系统内部异常"),
    OPERATION_ERROR(50001, "操作失败");

    /**
     * 状态码
     */
    private final int code;

    /**
     * 错误信息
     */
    private final String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
