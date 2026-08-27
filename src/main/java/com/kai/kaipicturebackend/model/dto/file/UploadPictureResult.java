package com.kai.kaipicturebackend.model.dto.file;

import lombok.Data;

import java.io.Serializable;

/**
 * 上传图片的解析结果（内部类，不直接给前端）。
 *
 * 第 4 期任务：
 * 1. 理解它的作用：上传图片时，数据万象会解析出图片的宽高、格式、大小等
 *    信息，用这个类承接，再赋值给 Picture 实体保存
 * 2. 第 6 期：图片压缩（转 WebP）后，这里要新增缩略图字段 thumbnailUrl
 */
@Data
public class UploadPictureResult implements Serializable {

    /**
     * 图片地址
     */
    private String url;

    /**
     * 图片名称
     */
    private String picName;

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
     * 图片格式
     */
    private String picFormat;

    /**
     * 缩略图 url（第 6 期加）
     */
    private String thumbnailUrl;

    /**
     * 图片主色调（第 8 期加，颜色搜索）
     */
    private String picColor;

    private static final long serialVersionUID = 1L;
}
