package com.kai.kaipicturebackend.model.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户视图（管理员分页查询用户时返回）。
 *
 * 第 3 期任务：
 * 1. 对比 LoginUserVO：为什么用户列表的 VO 字段更少？
 * 2. 思考：如果前端需要"创建人昵称"，而 user 表里没冗余，怎么查？
 *    （提示：SQL 关联查询，或 MyBatis-Plus 手动组装 —— 第 4 期 PictureVO 会讲）
 */
@Data
public class UserVO implements Serializable {

    /**
     * 用户 id
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

    /**
     * 创建时间
     */
    private Date createTime;

    private static final long serialVersionUID = 1L;
}
