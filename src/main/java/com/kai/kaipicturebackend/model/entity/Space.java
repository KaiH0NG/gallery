package com.kai.kaipicturebackend.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 空间实体（对应 space 表，第 7 期开始使用）。
 *
 * 设计要点（第 7 期任务，面试常问）：
 * - 限额字段 maxSize/maxCount 直接存在空间表里，而不是每次按级别现算
 *   → 好处：管理员可以单独修改某个空间的限额，不跟级别绑定
 * - totalSize/totalCount 是冗余字段（已用容量/数量），避免每次 COUNT 全表
 *   → 代价：上传/删除图片时要同步维护，必须用事务保证一致
 * - spaceType：第 11 期加，区分私有空间/团队空间
 */
@TableName(value = "space")
@Data
public class Space implements Serializable {

    /**
     * 空间 id
     */
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 空间名称
     */
    private String spaceName;

    /**
     * 空间级别：0-普通版 1-专业版 2-旗舰版（对应 SpaceLevelEnum）
     */
    private Integer spaceLevel;

    /**
     * 空间图片的最大总大小（字节）
     */
    private Long maxSize;

    /**
     * 空间图片的最大数量
     */
    private Long maxCount;

    /**
     * 当前空间下图片的总大小（字节）
     */
    private Long totalSize;

    /**
     * 当前空间下的图片数量
     */
    private Long totalCount;

    /**
     * 空间类型：0-私有 1-团队（第 11 期）
     */
    private Integer spaceType;

    /**
     * 创建用户 id
     */
    private Long userId;

    /**
     * 编辑时间
     */
    private Date editTime;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 是否删除
     */
    private Integer isDelete;

    private static final long serialVersionUID = 1L;
}
