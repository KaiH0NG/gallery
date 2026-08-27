package com.kai.kaipicturebackend.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 全局跨域配置。
 *
 * 第 2 期任务：
 * 1. 理解"跨域"：前端 http://localhost:5173 请求后端 http://localhost:8123，端口不同 = 跨域
 * 2. 浏览器同源策略只影响浏览器环境（Postman 不受影响）
 * 3. 思考：allowedOriginPatterns("*") 在安全上有什么风险？生产环境怎么改？
 *    （提示：上线后前端和后端同域名部署，就不需要跨域了，或者只允许自己的域名）
 */
@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOriginPatterns("*")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(true)
                .maxAge(3600);
    }
}
