package com.kai.kaipicturebackend.model.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 空间成员视图（第 11 期）。
 *
 * 第 11 期任务：
 * 1. 对比 SpaceUser 实体：多了 userName / userAvatar（成员信息，冗余组装）
 * 2. 成员列表接口返回它，前端直接展示成员昵称和头像
 */
@Data
public class SpaceUserVO implements Serializable {

    /**
     * id
     */
    private Long id;

    /**
     * 空间 id
     */
    private Long spaceId;

    /**
     * 用户 id
     */
    private Long userId;

    /**
     * 空间角色
     */
    private String spaceRole;

    /**
     * 用户昵称（冗余组装）
     */
    private String userName;

    /**
     * 用户头像（冗余组装）
     */
    private String userAvatar;

    /**
     * 创建时间
     */
    private Date createTime;

    private static final long serialVersionUID = 1L;

    // TODO 第 11 期：实现 objToVo
}

// 依赖提示：需要 import com.kai.kaipicturebackend.model.entity.SpaceUser;
