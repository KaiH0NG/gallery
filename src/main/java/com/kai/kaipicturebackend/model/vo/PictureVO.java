package com.kai.kaipicturebackend.model.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 图片视图（返回给前端的图片信息）。
 *
 * 第 4 期任务：
 * 1. 对比 Picture 实体：多了 userName（创建人昵称，冗余字段，方便前端直接展示）
 * 2. 实现 objToVo / voToObj 静态方法（教程写法，转换逻辑放 VO 里）
 * 3. 第 6 期：加 thumbnailUrl（列表页用缩略图）；第 8 期：加 picColor
 */
@Data
public class PictureVO implements Serializable {

    /**
     * 图片 id
     */
    private Long id;

    /**
     * 图片地址
     */
    private String url;

    /**
     * 缩略图 url（第 6 期）
     */
    private String thumbnailUrl;

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
     * 图片主色调（第 8 期）
     */
    private String picColor;

    /**
     * 空间 id（第 7 期）
     */
    private Long spaceId;

    /**
     * 创建用户 id
     */
    private Long userId;

    /**
     * 创建用户昵称（冗余组装，第 4 期任务）
     */
    private String userName;

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
    private Date reviewTime;

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

    private static final long serialVersionUID = 1L;

    // TODO 第 4 期：实现 objToVo(Picture picture) / voToObj(PictureVO pictureVO)
    // 提示：BeanUtils.copyProperties + 手动组装 userName
}

// 依赖提示：需要 import com.kai.kaipicturebackend.model.entity.Picture;
