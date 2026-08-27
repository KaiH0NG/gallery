package com.kai.kaipicturebackend.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 空间成员实体（对应 space_user 表，第 11 期团队空间使用）。
 *
 * 第 11 期任务：
 * 1. 理解为什么成员关系单独一张表（空间-用户是多对多）
 * 2. spaceRole：空间内角色（user/admin），和系统角色是两套体系
 * 3. 思考：团队空间的创建者，需要在 space_user 里也加一条记录吗？
 */
@TableName(value = "space_user")
@Data
public class SpaceUser implements Serializable {

    /**
     * id
     */
    @TableId(type = IdType.ASSIGN_ID)
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
     * 空间角色：user/admin（SpaceUserRoleEnum）
     */
    private String spaceRole;

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
