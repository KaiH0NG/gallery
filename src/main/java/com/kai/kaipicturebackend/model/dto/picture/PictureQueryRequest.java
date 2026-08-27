package com.kai.kaipicturebackend.model.dto.picture;

import com.kai.kaipicturebackend.common.PageRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 图片查询请求 —— 前端所有筛选条件都在这里。
 *
 * 第 4~7 期任务（字段会逐步补全）：
 * - 第 4 期：基础筛选（名称/分类/标签/用户）
 * - 第 5 期：审核筛选（reviewStatus/reviewMessage/reviewerId）
 * - 第 7 期：空间筛选（spaceId，空间内查图）
 *
 * 思考：
 * 1. 为什么查询条件里既有精确匹配（category）又有模糊匹配（name）？
 * 2. 哪些条件用 eq，哪些用 like？（看 QueryWrapper 用法）
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class PictureQueryRequest extends PageRequest implements Serializable {

    /**
     * 图片 id
     */
    private Long id;

    /**
     * 图片名称（模糊）
     */
    private String name;

    /**
     * 简介（模糊）
     */
    private String introduction;

    /**
     * 分类（精确）
     */
    private String category;

    /**
     * 标签（JSON 数组字符串）
     */
    private String tags;

    /**
     * 图片体积
     */
    private Long picSize;

    /**
     * 图片宽度
     */
    private Integer picWidth;

    /**
     * 图片高度
     */
    private Integer picHeight;

    /**
     * 图片宽高比例
     */
    private Double picScale;

    /**
     * 图片格式
     */
    private String picFormat;

    /**
     * 创建用户 id
     */
    private Long userId;

    /**
     * 审核状态（第 5 期）
     */
    private Integer reviewStatus;

    /**
     * 审核信息（第 5 期）
     */
    private String reviewMessage;

    /**
     * 审核人 id（第 5 期）
     */
    private Long reviewerId;

    /**
     * 空间 id（第 7 期：为空表示查询公共图库）
     */
    private Long spaceId;

    private static final long serialVersionUID = 1L;
}
