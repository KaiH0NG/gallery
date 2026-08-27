package com.kai.kaipicturebackend.model.vo.space;

import lombok.Data;

import java.io.Serializable;

/**
 * 空间资源使用分析响应（第 10 期）—— 完整示例。
 *
 * 第 10 期任务：理解它如何支撑前端"仪表盘"图表：
 * - 已用大小/总大小 → 进度条比例
 * - 已用数量/总数量 → 数量占比
 * - 图片数量为 0 时前端要防除零（前端处理或这里给默认值）
 */
@Data
public class SpaceUsageAnalyzeResponse implements Serializable {

    /**
     * 已用大小（字节）
     */
    private Long usedSize;

    /**
     * 总大小（字节）
     */
    private Long maxSize;

    /**
     * 空间使用比例（0~1）
     */
    private Double sizeUsageRatio;

    /**
     * 当前图片数量
     */
    private Long usedCount;

    /**
     * 最大图片数量
     */
    private Long maxCount;

    /**
     * 图片数量占比（0~1）
     */
    private Double countUsageRatio;

    private static final long serialVersionUID = 1L;
}
