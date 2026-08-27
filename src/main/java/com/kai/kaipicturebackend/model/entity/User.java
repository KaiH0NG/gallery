package com.kai.kaipicturebackend.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户实体（对应 user 表）。
 *
 * 字段说明（第 3 期任务：每个字段都要理解为什么这么设计）：
 * - userAccount 唯一：建表时加了唯一索引，数据库层面防止重复注册
 * - userPassword：只能存加密后的密码！绝不允许明文
 * - userRole：user / admin，配合 UserRoleEnum 使用
 * - editTime：编辑时间（第 4 期会讲到：创建时间、编辑时间、更新时间三者区别）
 * - isDelete：逻辑删除（配合 MyBatis-Plus 全局配置，查询自动过滤）
 */
@TableName(value = "user")
@Data
public class User implements Serializable {

    /**
     * 用户 id（雪花算法生成，全局唯一）
     */
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 账号（唯一）
     */
    private String userAccount;

    /**
     * 密码（加密存储）
     */
    private String userPassword;

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
     * 编辑时间
     */
    private Date editTime;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 是否删除（0 未删除，1 已删除）
     */
    private Integer isDelete;

    private static final long serialVersionUID = 1L;
}
