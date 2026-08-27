package com.kai.kaipicturebackend.model.dto.space;

import lombok.Data;

import java.io.Serializable;

/**
 * 空间更新请求（第 7 期）—— 管理员全量修改空间。
 *
 * 第 7 期任务：
 * 1. 管理员可以修改级别和限额（maxSize/maxCount），普通用户不行
 * 2. 思考：修改 maxSize 为更小值，但空间里已经存了很多图，会怎样？
 *    （提示：限额校验只拦截"新增"操作，存量数据需要管理员自己处理）
 */
@Data
public class SpaceUpdateRequest implements Serializable {

    /**
     * 空间 id
     */
    private Long id;

    /**
     * 空间名称
     */
    private String spaceName;

    /**
     * 空间级别
     */
    private Integer spaceLevel;

    /**
     * 空间图片的最大总大小
     */
    private Long maxSize;

    /**
     * 空间图片的最大数量
     */
    private Long maxCount;

    private static final long serialVersionUID = 1L;
}
