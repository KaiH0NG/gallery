package com.kai.kaipicturebackend.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * COS 对象存储配置类 —— 读取 application.yml 里 cos.client 开头的配置。
 *
 * 第 4 期任务：
 * 1. 理解 @ConfigurationProperties：把配置文件自动绑定到类属性
 * 2. 去腾讯云控制台创建存储桶，把 host / secretId / secretKey / region / bucket 填到 yml
 * 3. 开通"数据万象"服务（图片上传时要用它解析图片信息）
 */
@Configuration
@ConfigurationProperties(prefix = "cos.client")
@Data
public class CosClientConfig {

    /**
     * 存储桶访问域名（形如 https://xxx.cos.ap-shanghai.myqcloud.com）
     */
    private String host;

    /**
     * 访问密钥 id
     */
    private String secretId;

    /**
     * 访问密钥 key
     */
    private String secretKey;

    /**
     * 存储桶所在区域（形如 ap-shanghai）
     */
    private String region;

    /**
     * 存储桶名称
     */
    private String bucket;
}
