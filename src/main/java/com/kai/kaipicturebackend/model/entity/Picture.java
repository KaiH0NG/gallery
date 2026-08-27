package com.kai.kaipicturebackend.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 图片实体（对应 picture 表）—— 本项目最核心的表。
 *
 * 字段分 4 类，第 4~8 期陆续补全：
 * 1. 基本信息（第 4 期）：url、name、introduction、category、tags
 * 2. 图片信息（第 4 期）：picSize、picWidth、picHeight、picScale、picFormat（上传时由数据万象解析）
 * 3. 归属与审核（第 5/7 期）：userId、spaceId、reviewStatus、reviewMessage、reviewerId、reviewTime
 * 4. 优化字段（第 6/8 期）：thumbnailUrl（缩略图）、picColor（主色调，颜色搜索用）
 */
@TableName(value = "picture")
@Data
public class Picture implements Serializable {

    /**
     * 图片 id
     */
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 图片访问地址（COS 完整 URL）
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
     * 标签（JSON 数组字符串，思考：为什么不用关联表？）
     */
    private String tags;

    /**
     * 图片体积（字节）
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
     * 图片格式（png/jpg/webp...）
     */
    private String picFormat;

    /**
     * 图片主色调（十六进制，如 #FFFFFF；第 8 期颜色搜索）
     */
    private String picColor;

    /**
     * 缩略图 url（第 6 期：列表页加载缩略图，详情页才加载原图）
     */
    private String thumbnailUrl;

    /**
     * 空间 id（为空表示公共图库；第 7 期加）
     */
    private Long spaceId;

    /**
     * 创建用户 id
     */
    private Long userId;

    /**
     * 审核状态：0-待审核 1-通过 2-拒绝（第 5 期）
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
     * 审核时间（第 5 期）
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

    /**
     * 是否删除
     */
    private Integer isDelete;

    private static final long serialVersionUID = 1L;
}
