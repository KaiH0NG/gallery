package com.kai.kaipicturebackend.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * MyBatis-Plus 配置。
 *
 * 第 2 期任务：
 * 1. 理解分页插件的作用：没有它，Page 分页查询会查出全表
 * 2. 扩展知识（第 7 期后可以研究）：MyBatis-Plus 还有数据权限插件，
 *    可以在 SQL 层自动追加"空间 id"过滤条件，实现空间数据隔离
 */
@Configuration
public class MyBatisPlusConfig {

    /**
     * 拦截器（分页插件）
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        PaginationInnerInterceptor paginationInnerInterceptor = new PaginationInnerInterceptor(DbType.MYSQL);
        paginationInnerInterceptor.setMaxLimit(50L); // 单页最多 50 条，防止有人一次查全库
        interceptor.addInnerInterceptor(paginationInnerInterceptor);
        return interceptor;
    }
}
