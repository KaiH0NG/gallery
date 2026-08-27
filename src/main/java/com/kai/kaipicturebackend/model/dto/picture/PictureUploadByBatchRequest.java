package com.kai.kaipicturebackend.model.dto.picture;

import lombok.Data;

import java.io.Serializable;

/**
 * 批量抓取图片请求（第 5 期，仅管理员）。
 *
 * 第 5 期任务：
 * 1. 理解流程：用 Jsoup 请求外部图片搜索接口 → 解析返回的图片列表
 *    → 逐张下载转存到 COS → 创建图片记录
 * 2. 思考：为什么 count 要限制最大值？（防止一次抓太多把 COS 和带宽打爆）
 * 3. 扩展：namePrefix 给抓取的图片统一命名，方便管理
 */
@Data
public class PictureUploadByBatchRequest implements Serializable {

    /**
     * 搜索词（要抓取什么图片）
     */
    private String searchText;

    /**
     * 抓取数量（限制 1~30）
     */
    private Integer count;

    /**
     * 名称前缀（可选，给图片统一命名）
     */
    private String namePrefix;

    /**
     * 分类（可选，给抓取的图片统一分类）
     */
    private String category;

    /**
     * 标签（可选，给抓取的图片统一打标签）
     */
    private String tags;

    private static final long serialVersionUID = 1L;
}
