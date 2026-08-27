package com.kai.kaipicturebackend.model.dto.space;

import com.kai.kaipicturebackend.common.PageRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 空间查询请求（第 7 期）。
 *
 * 第 7 期任务：
 * 1. 空间分页：管理员查所有空间用
 * 2. 思考：普通用户能查别人的空间列表吗？（不能，接口层做权限控制）
 * 3. 第 11 期：加 spaceType 查询条件（按类型筛选）
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SpaceQueryRequest extends PageRequest implements Serializable {

    /**
     * 空间 id
     */
    private Long id;

    /**
     * 空间名称（模糊）
     */
    private String spaceName;

    /**
     * 空间级别
     */
    private Integer spaceLevel;

    /**
     * 空间类型（第 11 期）
     */
    private Integer spaceType;

    /**
     * 创建用户 id（第 11 期：查某个用户的团队空间）
     */
    private Long userId;

    private static final long serialVersionUID = 1L;
}
