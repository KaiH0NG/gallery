package com.kai.kaipicturebackend.model.dto.picture;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 图片批量编辑请求（第 8 期）。
 *
 * 第 8 期任务：
 * 1. 理解批量操作的设计：传一个 id 列表 + 要统一修改的字段
 * 2. 思考：批量修改要做权限校验吗？校验谁？（空间权限）
 * 3. 注意：字段传空值 = 不修改还是清空？要设计好语义
 */
@Data
public class PictureEditByBatchRequest implements Serializable {

    /**
     * 图片 id 列表（要批量修改哪些图）
     */
    private List<Long> pictureIdList;

    /**
     * 空间 id（批量操作只在某个空间内生效）
     */
    private Long spaceId;

    /**
     * 批量修改的名称（可选）
     */
    private String name;

    /**
     * 批量修改的分类（可选）
     */
    private String category;

    /**
     * 批量修改的标签（可选）
     */
    private String tags;

    private static final long serialVersionUID = 1L;
}
