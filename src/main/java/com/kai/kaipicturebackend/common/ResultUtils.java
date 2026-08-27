package com.kai.kaipicturebackend.common;

/**
 * 统一响应工具类 —— 快速构造 BaseResponse，避免到处 new。
 *
 * 第 3 期任务：
 * 1. 理解为什么用工具类包装（一处修改，全局生效）
 * 2. 在 controller 里养成习惯：成功返回 ResultUtils.success(...)
 */
public class ResultUtils {

    /**
     * 成功
     */
    public static <T> BaseResponse<T> success(T data) {
        return new BaseResponse<>(0, data, "ok");
    }

    /**
     * 失败（按错误码）
     */
    public static <T> BaseResponse<T> error(ErrorCode errorCode) {
        return new BaseResponse<>(errorCode);
    }

    /**
     * 失败（自定义状态码和信息）
     */
    public static <T> BaseResponse<T> error(int code, String message) {
        return new BaseResponse<>(code, null, message);
    }

    /**
     * 失败（错误码 + 自定义信息，比如"参数错误：名称过长"）
     */
    public static <T> BaseResponse<T> error(ErrorCode errorCode, String message) {
        return new BaseResponse<>(errorCode.getCode(), null, message);
    }
}
