package com.kai.kaipicturebackend.exception;

import com.kai.kaipicturebackend.common.BaseResponse;
import com.kai.kaipicturebackend.common.ErrorCode;
import com.kai.kaipicturebackend.common.ResultUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理器 —— 项目里任何地方抛出的异常，最终都汇聚到这里。
 *
 * 第 3 期任务：
 * 1. 理解 @RestControllerAdvice 的作用（对所有 controller 生效）
 * 2. 理解处理逻辑：业务异常 → 返回它的 code/message；其他异常 → 返回系统错误
 * 3. 重要：未知异常一定要 log.error 打日志，否则线上出问题根本查不到
 * 4. 扩展任务：补一个兜底 Exception 处理方法，处理所有未知异常
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 业务异常
     */
    @ExceptionHandler(BusinessException.class)
    public BaseResponse<?> businessExceptionHandler(BusinessException e) {
        log.warn("BusinessException", e);
        return ResultUtils.error(e.getCode(), e.getMessage());
    }

    /**
     * 运行时异常
     */
    @ExceptionHandler(RuntimeException.class)
    public BaseResponse<?> runtimeExceptionHandler(RuntimeException e) {
        log.error("RuntimeException", e);
        return ResultUtils.error(ErrorCode.SYSTEM_ERROR, "系统错误");
    }

    // TODO 第 3 期（扩展）：添加兜底处理
    // @ExceptionHandler(Exception.class)
    // public BaseResponse<?> exceptionHandler(Exception e) { ... }
}
