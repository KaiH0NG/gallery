package com.kai.kaipicturebackend.model.dto.space;

import lombok.Data;

import java.io.Serializable;

/**
 * 空间编辑请求（第 7 期）—— 空间所有者修改自己的空间。
 *
 * 第 7 期任务：
 * 1. 对比 SpaceUpdateRequest：普通用户只能改名称
 * 2. 权限校验：只有空间创建者（或管理员）能编辑
 */
@Data
public class SpaceEditRequest implements Serializable {

    /**
     * 空间 id
     */
    private Long id;

    /**
     * 空间名称
     */
    private String spaceName;

    private static final long serialVersionUID = 1L;
}
