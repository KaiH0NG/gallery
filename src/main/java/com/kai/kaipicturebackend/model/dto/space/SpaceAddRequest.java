package com.kai.kaipicturebackend.model.dto.space;

import lombok.Data;

import java.io.Serializable;

/**
 * 开通空间请求（第 7 期）。
 *
 * 第 7 期任务：
 * 1. 思考：开通空间时，前端只传名称和级别，为什么？
 *    （限额由后端根据 SpaceLevelEnum 填充，不信任前端）
 * 2. 第 11 期：加 spaceType 字段，支持开通团队空间
 */
@Data
public class SpaceAddRequest implements Serializable {

    /**
     * 空间名称
     */
    private String spaceName;

    /**
     * 空间级别：0-普通版 1-专业版 2-旗舰版
     */
    private Integer spaceLevel;

    /**
     * 空间类型：0-私有 1-团队（第 11 期）
     */
    private Integer spaceType;

    private static final long serialVersionUID = 1L;
}
