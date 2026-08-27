package com.kai.kaipicturebackend.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 权限校验注解 —— 加在 controller 方法上，声明"调用这个接口需要什么角色"。
 *
 * 第 3 期任务：
 * 1. 理解三个元注解：
 *    - @Target(ElementType.METHOD)：只能加在方法上
 *    - @Retention(RUNTIME)：运行时保留（切面才能读取）
 * 2. 用法：@AuthCheck(mustRole = "admin") 表示只有管理员能调用
 * 3. 实现原理：配合 aop/AuthInterceptor 切面使用
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AuthCheck {

    /**
     * 必须有某个角色（为空表示只需登录）
     */
    String mustRole() default "";
}
