package com.kai.kaipicturebackend.controller;

import com.kai.kaipicturebackend.common.BaseResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 空间分析接口（第 10 期）。
 *
 * 参考接口：
 * POST /spaceAnalyze/usage        空间资源使用分析
 * POST /spaceAnalyze/category     分类分析
 * POST /spaceAnalyze/tag          标签分析
 * POST /spaceAnalyze/size         大小分析
 * POST /spaceAnalyze/user         用户上传行为分析
 * POST /spaceAnalyze/rank         空间使用排行（管理员）
 */
@RestController
@RequestMapping("/spaceAnalyze")
public class SpaceAnalyzeController {

    @Resource
    private com.kai.kaipicturebackend.service.SpaceAnalyzeService spaceAnalyzeService;

    // TODO 第 10 期：补全接口
}
