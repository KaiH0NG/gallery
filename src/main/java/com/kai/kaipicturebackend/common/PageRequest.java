package com.kai.kaipicturebackend.common;

import lombok.Data;

import java.io.Serializable;

/**
 * 分页请求基类 —— 所有分页查询请求都继承它。
 *
 * 第 3 期任务：
 * 1. 理解为什么把分页参数抽成基类（用户分页、图片分页、空间分页都用）
 * 2. 思考：current 和 pageSize 需要做边界校验吗？在哪里校验？
 *
 * 用法示例（第 4 期）：
 * public class PictureQueryRequest extends PageRequest { ... }
 */
@Data
public class PageRequest implements Serializable {

    /**
     * 当前页号（从 1 开始）
     */
    private long current = 1;

    /**
     * 页面大小（每页条数）
     */
    private long pageSize = 10;

    /**
     * 排序字段（按哪个字段排序，比如 createTime）
     */
    private String sortField;

    /**
     * 排序顺序（ascend / descend）
     */
    private String sortOrder;

    private static final long serialVersionUID = 1L;
}
