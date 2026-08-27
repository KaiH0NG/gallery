package com.kai.kaipicturebackend.model.dto.user;

import com.kai.kaipicturebackend.common.PageRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 用户查询请求（管理员分页查询用户用）。
 *
 * 第 3 期任务：
 * 1. 理解继承 PageRequest：分页参数（current/pageSize）直接用基类的
 * 2. 思考：为什么要根据条件动态拼 SQL？（MyBatis-Plus QueryWrapper）
 * 3. 为什么查询请求里没有密码字段？（查询条件不需要密码）
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserQueryRequest extends PageRequest implements Serializable {

    /**
     * 用户昵称（模糊查询）
     */
    private String userName;

    /**
     * 用户角色（精确查询）
     */
    private String userRole;

    private static final long serialVersionUID = 1L;
}
