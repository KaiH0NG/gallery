package com.kai.kaipicturebackend.manager;

import com.kai.kaipicturebackend.model.dto.file.UploadPictureResult;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文件上传服务 —— 专门处理"上传图片并解析图片信息"的业务封装。
 *
 * 第 4 期任务：
 * 1. 理解它和 CosManager 的区别：
 *    - CosManager：通用对象存储操作（上传/下载/删除任何文件）
 *    - FileManager：业务文件服务（只关心图片，上传后还要解析宽高、格式等）
 * 2. TODO：实现 uploadPicture 方法，流程：
 *    a. 校验文件（为空？格式对不对？大小超限？）
 *    b. 生成存储路径 key（规则：业务前缀 + 日期 + 随机文件名）
 *    c. 调 CosManager 上传（第 4 期扩展：带图片解析）
 *    d. 把解析结果封装成 UploadPictureResult 返回
 * 3. 第 5 期：教程用"模板方法模式"重构本类（PictureUploadTemplate），
 *    支持文件上传和 URL 上传两种方式，本类会标注 @Deprecated 废弃
 */
@Component
@Deprecated // TODO 第 5 期：实现 PictureUploadTemplate 后，本类不再使用
public class FileManager {

    // TODO 第 4 期：注入 CosManager，实现 uploadPicture

    /**
     * 上传图片并返回图片解析信息
     *
     * @param multipartFile    文件
     * @param uploadPathPrefix 上传路径前缀（如 public / private）
     * @return 图片信息（url、宽高、格式、大小等）
     */
    public UploadPictureResult uploadPicture(MultipartFile multipartFile, String uploadPathPrefix) {
        // TODO 第 4 期：实现
        // 提示：
        // 1. 校验：文件为空抛 PARAMS_ERROR；格式/大小校验
        // 2. 生成唯一文件名：Hutool 的 IdUtil 或 UUID + 原文件后缀
        // 3. 路径：uploadPathPrefix + "/" + 日期 + "/" + 文件名
        // 4. 调 CosManager 上传并解析
        return null;
    }
}
