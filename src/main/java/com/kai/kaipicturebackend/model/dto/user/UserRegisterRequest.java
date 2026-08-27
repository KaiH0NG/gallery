package com.kai.kaipicturebackend.model.dto.user;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户注册请求（前端传给后端的参数）。
 *
 * 第 3 期任务：
 * 1. 理解 DTO 的作用：只接收前端需要传的参数，不是把整个实体传过来
 *    （为什么？前端传什么你收什么，避免前端乱传字段覆盖数据库）
 * 2. 思考：这些参数在哪做校验？（Service 里，不信任前端）
 */
@Data
public class UserRegisterRequest implements Serializable {

    /**
     * 账号
     */
    private String userAccount;

    /**
     * 密码
     */
    private String userPassword;

    /**
     * 确认密码（用于校验两次输入一致，前端防手滑，后端防绕过）
     */
    private String checkPassword;

    private static final long serialVersionUID = 1L;
}
