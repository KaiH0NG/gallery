package com.kai.kaipicturebackend.model.dto.picture;

import lombok.Data;

import java.io.Serializable;

/**
 * 图片审核请求（第 5 期，仅管理员）。
 *
 * 第 5 期任务：
 * 1. 注意：不需要 reviewerId 和 reviewTime 字段！这两个由系统自动填充
 *    （从登录用户和当前时间获取），前端传了也不能信
 * 2. 状态流转：待审核(0) → 通过(1) / 拒绝(2)
 */
@Data
public class PictureReviewRequest implements Serializable {

    /**
     * 图片 id
     */
    private Long id;

    /**
     * 审核状态：1-通过 2-拒绝
     */
    private Integer reviewStatus;

    /**
     * 审核信息（拒绝时填原因）
     */
    private String reviewMessage;

    private static final long serialVersionUID = 1L;
}
