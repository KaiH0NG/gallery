package com.kai.kaipicturebackend.model.dto.user;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户登录请求。
 *
 * 第 3 期任务：
 * 1. 思考：登录为什么不需要 checkPassword？
 * 2. 登录成功后返回什么？密码怎么处理？（→ 见 LoginUserVO 数据脱敏）
 */
@Data
public class UserLoginRequest implements Serializable {

    /**
     * 账号
     */
    private String userAccount;

    /**
     * 密码
     */
    private String userPassword;

    private static final long serialVersionUID = 1L;
}
