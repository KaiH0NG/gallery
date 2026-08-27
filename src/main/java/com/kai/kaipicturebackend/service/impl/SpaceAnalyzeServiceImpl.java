package com.kai.kaipicturebackend.service.impl;

import com.kai.kaipicturebackend.model.dto.space.SpaceAnalyzeRequest;
import com.kai.kaipicturebackend.model.entity.User;
import com.kai.kaipicturebackend.model.vo.space.SpaceUsageAnalyzeResponse;
import com.kai.kaipicturebackend.service.SpaceAnalyzeService;
import org.springframework.stereotype.Service;

/**
 * 空间分析服务实现（第 10 期）。
 *
 * 实现套路（先理解再写）：
 * 1. 校验分析范围（queryPublic / queryAll / spaceId 三选一）
 * 2. 校验权限：
 *    - queryAll → 仅管理员
 *    - queryPublic → 仅管理员
 *    - spaceId → 空间创建者或管理员
 * 3. 拼查询条件（QueryWrapper：spaceId 或公共图库 spaceId is null）
 * 4. 聚合查询（count / sum）→ 组装响应
 * 5. 每个分析功能 = 一个方法，共用范围校验逻辑
 */
@Service
public class SpaceAnalyzeServiceImpl implements SpaceAnalyzeService {

    @Override
    public SpaceUsageAnalyzeResponse getSpaceUsageAnalyze(SpaceAnalyzeRequest spaceAnalyzeRequest, User loginUser) {
        // TODO 第 10 期：实现
        // 提示：用 pictureService.count() / 求和 totalSize
        return null;
    }
}
