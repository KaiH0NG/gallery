package com.kai.kaipicturebackend.model.dto.picture;

import lombok.Data;

import java.io.Serializable;

/**
 * 图片上传请求（配合文件一起传，或单独传）。
 *
 * 第 4 期任务：
 * 1. 理解文件上传接口的特殊性：文件走 multipart/form-data，
 *    JSON 参数用 @RequestPart 接收
 * 2. 第 7 期：给私有空间传图时，需要传 spaceId 表示图片属于哪个空间
 * 3. 思考：id 字段是干嘛的？（编辑图片时重新上传，替换原图）
 */
@Data
public class PictureUploadRequest implements Serializable {

    /**
     * 图片 id（编辑时传，用于替换原图）
     */
    private Long id;

    /**
     * 空间 id（第 7 期：为空表示公共图库）
     */
    private Long spaceId;

    private static final long serialVersionUID = 1L;
}
