package com.kai.kaipicturebackend.model.dto.picture;

import lombok.Data;

import java.io.Serializable;

/**
 * 按颜色搜索图片请求（第 8 期）。
 *
 * 第 8 期任务：
 * 1. 理解"颜色搜索"原理：
 *    上传时提取图片主色调存到 picColor 字段 → 搜索时用欧几里得距离
 *    计算目标颜色与每张图主色调的相似度 → 按相似度排序返回
 * 2. 为什么限定在空间内？（公共图库图片太多，全量算相似度太慢）
 */
@Data
public class SearchPictureByColorRequest implements Serializable {

    /**
     * 空间 id（在哪个空间里搜）
     */
    private Long spaceId;

    /**
     * 目标颜色（十六进制，如 #FF0000）
     */
    private String picColor;

    private static final long serialVersionUID = 1L;
}
