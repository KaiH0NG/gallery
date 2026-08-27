package com.kai.kaipicturebackend.manager;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.model.*;
import com.qcloud.cos.region.Region;
import com.kai.kaipicturebackend.config.CosClientConfig;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;

/**
 * COS 对象存储操作类 —— 封装腾讯云 COS 的通用操作（上传、下载、删除）。
 *
 * 第 4 期任务：
 * 1. 理解 @PostConstruct：项目启动后自动初始化 COSClient（只初始化一次）
 * 2. TODO：补全 putObject（上传文件对象）、getObject（下载）、deleteObject（删除）方法
 * 3. 完成 pom.xml 里 cos_api 依赖的引入和 yml 配置后，这个类才能编译通过
 * 4. 思考：为什么把 COS 操作封装成 manager，而不是直接在 service 里写？
 *    （提示：service 只关心业务，不关心用什么存储。以后换 OSS/本地存储只改这里）
 */
@Component
public class CosManager {

    @Resource
    private CosClientConfig cosClientConfig;

    /**
     * COS 客户端
     */
    private COSClient cosClient;

    /**
     * 项目启动时初始化 COS 客户端
     */
    @PostConstruct
    public void init() {
        COSCredentials credentials = new BasicCOSCredentials(cosClientConfig.getSecretId(), cosClientConfig.getSecretKey());
        ClientConfig clientConfig = new ClientConfig(new Region(cosClientConfig.getRegion()));
        this.cosClient = new COSClient(credentials, clientConfig);
    }

    /**
     * 上传对象（文件流）
     *
     * @param key            对象的唯一标识（存储路径，如 public/2026/08/17/xxx.png）
     * @param inputStream    文件输入流
     * @param contentLength  文件大小（字节）
     * @param contentType    文件类型（如 image/png）
     * @return 对象元数据
     */
    public ObjectMetadata putObject(String key, InputStream inputStream, long contentLength, String contentType) throws IOException {
        // TODO 第 4 期：实现
        // 提示：构造 ObjectMetadata，设置长度和类型，调用 cosClient.putObject(bucket, key, inputStream, metadata)
        return null;
    }

    /**
     * 下载对象
     *
     * @param key 对象的唯一标识
     * @return COS 对象（可从中获取输入流）
     */
    public COSObject getObject(String key) {
        // TODO 第 4 期：实现
        // 提示：cosClient.getObject(bucket, key)
        return null;
    }

    /**
     * 删除对象
     *
     * @param key 对象的唯一标识
     */
    public void deleteObject(String key) {
        // TODO 第 4 期：实现
        // 提示：cosClient.deleteObject(bucket, key)
        // 注意：删除图片记录时也要删 COS 里的文件（第 7 期 clearPictureFile 会用到）
    }

    // TODO 第 4 期（扩展）：putObject 支持图片处理（数据万象）
    // 参考教程：上传时传 PictureOperations 参数，可以压缩图片（转 WebP）、生成缩略图、
    // 并返回图片的宽高、格式、主色调等信息
    // 第 6 期压缩、第 8 期颜色搜索都会用到
}
