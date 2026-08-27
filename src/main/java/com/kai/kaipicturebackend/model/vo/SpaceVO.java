package com.kai.kaipicturebackend.model.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 空间视图（第 7 期）。
 *
 * 第 7 期任务：
 * 1. 对比 Space 实体：VO 里可以加 userName（创建人昵称）方便前端展示
 * 2. 实现 objToVo / voToObj 静态方法
 * 3. 第 11 期：加 spaceType
 */
@Data
public class SpaceVO implements Serializable {

    /**
     * 空间 id
     */
    private Long id;

    /**
     * 空间名称
     */
    private String spaceName;

    /**
     * 空间级别
     */
    private Integer spaceLevel;

    /**
     * 最大总大小
     */
    private Long maxSize;

    /**
     * 最大图片数
     */
    private Long maxCount;

    /**
     * 已用总大小
     */
    private Long totalSize;

    /**
     * 已用图片数
     */
    private Long totalCount;

    /**
     * 空间类型（第 11 期）
     */
    private Integer spaceType;

    /**
     * 创建用户 id
     */
    private Long userId;

    /**
     * 创建用户昵称（冗余组装）
     */
    private String userName;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 编辑时间
     */
    private Date editTime;

    private static final long serialVersionUID = 1L;

    // TODO 第 7 期：实现 objToVo / voToObj
}

// 依赖提示：需要 import com.kai.kaipicturebackend.model.entity.Space;
