package com.kai.kaipicturebackend.model.dto.picture;

import lombok.Data;

import java.io.Serializable;

/**
 * 图片更新请求 —— 管理员全量更新图片信息。
 *
 * 第 4 期任务：
 * 1. 对比 PictureEditRequest：管理员可以改 url、图片信息、归属等所有字段
 * 2. 这个接口必须加 @AuthCheck(mustRole = "admin")
 * 3. 思考：为什么有"编辑"和"更新"两套？给普通用户开放全量更新会怎样？
 */
@Data
public class PictureUpdateRequest implements Serializable {

    /**
     * 图片 id
     */
    private Long id;

    /**
     * 图片地址
     */
    private String url;

    /**
     * 图片名称
     */
    private String name;

    /**
     * 简介
     */
    private String introduction;

    /**
     * 分类
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
     * 审核状态
     */
    private Integer reviewStatus;

    /**
     * 审核信息
     */
    private String reviewMessage;

    /**
     * 审核人 id
     */
    private Long reviewerId;

    /**
     * 审核时间
     */
    private java.util.Date reviewTime;

    private static final long serialVersionUID = 1L;
}
