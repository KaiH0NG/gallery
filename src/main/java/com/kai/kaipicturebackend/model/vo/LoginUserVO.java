package com.kai.kaipicturebackend.model.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 登录用户视图（脱敏后返回给前端）。
 *
 * 第 3 期任务：
 * 1. 理解"数据脱敏"：User 实体里有 userPassword，直接返回就泄露了
 * 2. 对比 User 实体：这里没有 userPassword、isDelete、editTime
 * 3. 实现方式：BeanUtils.copyProperties(user, loginUserVO) 只复制同名属性，
 *    不在 VO 里的字段自然就被过滤掉了
 */
@Data
public class LoginUserVO implements Serializable {

    /**
     * 用户 id
     */
    private Long id;

    /**
     * 账号
     */
    private String userAccount;

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
     * 用户角色：user/admin
     */
    private String userRole;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    private static final long serialVersionUID = 1L;
}
