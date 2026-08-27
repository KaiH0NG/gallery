package com.kai.kaipicturebackend.service;

import com.kai.kaipicturebackend.model.dto.space.SpaceAnalyzeRequest;
import com.kai.kaipicturebackend.model.entity.User;
import com.kai.kaipicturebackend.model.vo.space.SpaceUsageAnalyzeResponse;

/**
 * 空间分析服务接口（第 10 期）。
 *
 * 分析功能清单：
 * 1. 空间资源使用分析（仪表盘）
 * 2. 空间图片分类分析（分组条形图）
 * 3. 空间图片标签分析（词云图）
 * 4. 空间图片大小分析（饼图）
 * 5. 用户上传行为分析（折线图）
 * 6. 空间使用排行分析（柱状图，管理员）
 *
 * 第 10 期任务：先实现第 1 个，理解"分析范围校验 + 聚合查询"的套路，
 * 剩下的自己举一反三
 */
public interface SpaceAnalyzeService {

    /**
     * 空间资源使用分析
     */
    SpaceUsageAnalyzeResponse getSpaceUsageAnalyze(SpaceAnalyzeRequest spaceAnalyzeRequest, User loginUser);
}
