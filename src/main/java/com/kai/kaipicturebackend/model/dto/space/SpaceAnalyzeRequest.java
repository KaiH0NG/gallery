package com.kai.kaipicturebackend.model.dto.space;

import lombok.Data;

import java.io.Serializable;

/**
 * 空间分析请求（第 10 期）。
 *
 * 分析范围设计（教程要点）：
 * - queryAll：是否查询全空间（管理员用）
 * - queryPublic：是否查询公共图库（管理员用）
 * - spaceId：分析某个空间（用户分析自己的空间）
 * 三者互斥！接口里要校验"只能选一种范围"
 *
 * 第 10 期任务：
 * 1. 理解"范围"参数的设计（一个请求类复用 6 个分析功能）
 * 2. 子类扩展：分类分析、标签分析等会继承本类加参数
 */
@Data
public class SpaceAnalyzeRequest implements Serializable {

    /**
     * 是否查询公共图库
     */
    private boolean queryPublic;

    /**
     * 是否查询全空间
     */
    private boolean queryAll;

    /**
     * 空间 id
     */
    private Long spaceId;

    private static final long serialVersionUID = 1L;
}
