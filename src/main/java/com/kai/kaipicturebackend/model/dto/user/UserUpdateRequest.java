package com.kai.kaipicturebackend.model.dto.user;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户更新请求（管理员修改用户信息）。
 *
 * 第 3 期任务：
 * 1. 思考：为什么这里没有 userAccount 和 userPassword？
 *    （账号不可改、密码走专门的修改流程，防止误操作）
 * 2. 对比：UserRegisterRequest / UserLoginRequest / UserQueryRequest / UserUpdateRequest
 *    每个请求类都只包含自己需要的字段 —— 这就是 DTO 的设计思想
 */
@Data
public class UserUpdateRequest implements Serializable {

    /**
     * 要更新的用户 id
     */
    private Long id;

    /**
     * 用户昵称
     */
    private String userName;

    /**
     * 用户头像
     */
    private String userAvatar;

    /**
     * 用户简介
     */
    private String userProfile;

    /**
     * 用户角色
     */
    private String userRole;

    private static final long serialVersionUID = 1L;
}
