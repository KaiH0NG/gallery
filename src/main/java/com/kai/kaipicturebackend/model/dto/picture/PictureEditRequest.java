package com.kai.kaipicturebackend.model.dto.picture;

import lombok.Data;

import java.io.Serializable;

/**
 * 图片编辑请求 —— 普通用户/上传者编辑自己的图片。
 *
 * 第 4 期任务：
 * 1. 对比 PictureUpdateRequest：编辑（Edit）只能改少量字段，
 *    更新（Update）是管理员全量修改 —— 权限不同，字段范围也不同
 * 2. 思考：为什么 tags 用 String？（数据库存 JSON 数组字符串）
 */
@Data
public class PictureEditRequest implements Serializable {

    /**
     * 图片 id
     */
    private Long id;

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

    private static final long serialVersionUID = 1L;
}
