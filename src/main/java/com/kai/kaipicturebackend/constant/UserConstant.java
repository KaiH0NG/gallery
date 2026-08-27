package com.kai.kaipicturebackend.constant;

/**
 * 用户常量。
 *
 * 第 3 期任务：
 * 1. 理解为什么用常量而不是到处写 "user_login"、"admin"
 *    （写错一个字母，排查一小时）
 * 2. 思考：登录态存到 session 的 key，为什么叫 user_login？
 */
public interface UserConstant {

    /**
     * 用户登录态（存 session 用的键名）
     */
    String USER_LOGIN_STATE = "user_login";

    /**
     * 普通用户角色
     */
    String DEFAULT_ROLE = "user";

    /**
     * 管理员角色
     */
    String ADMIN_ROLE = "admin";
}
