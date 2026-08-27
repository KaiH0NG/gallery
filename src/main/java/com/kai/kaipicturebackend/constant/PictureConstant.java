package com.kai.kaipicturebackend.constant;

/**
 * 图片常量。
 *
 * 第 5 期任务：
 * 1. 思考：有哪些图片相关的常量需要定义？
 *    （提示：上传路径前缀、缩略图尺寸、支持的文件格式、文件大小上限……）
 * 2. 建议先写代码再回来补常量，看哪些"魔法值"需要提取
 */
public interface PictureConstant {

    /**
     * 上传路径前缀（按业务/日期组织目录）
     * 示例：public/2026/08/17/xxx.png  private/spaceId/2026/08/17/xxx.png
     */
    // TODO 第 4 期：定义 UPLOAD_PATH_PREFIX 相关常量

    /**
     * 支持上传的图片格式（第 4 期扩展任务：定义格式枚举时用）
     */
    // TODO 第 4 期：定义格式常量或枚举

    /**
     * 审核通过后，公共图库查询可见（第 5 期内容可见性控制）
     */
    // TODO 第 5 期：定义默认审核状态常量
}
