package com.kai.kaipicturebackend.model.dto.picture;

import lombok.Data;

import java.io.Serializable;

/**
 * 通过 URL 上传图片请求（第 5 期）。
 *
 * 第 5 期任务：
 * 1. 理解流程：后端拿 URL → 校验（格式/大小）→ 下载 → 转存到 COS
 *    → 和本地文件上传走同一套逻辑（模板方法模式）
 * 2. 思考：为什么不让前端直接把这个 URL 存进数据库？
 *    （外链可能失效、无法控制大小、无法做图片解析……）
 */
@Data
public class PictureUploadByUrlRequest implements Serializable {

    /**
     * 图片 URL 地址
     */
    private String fileUrl;

    /**
     * 图片名称（可选，不传用 URL 里的文件名）
     */
    private String picName;

    /**
     * 空间 id（第 7 期）
     */
    private Long spaceId;

    private static final long serialVersionUID = 1L;
}
