package com.kai.kaipicturebackend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 项目启动类。
 *
 * 第 2 期任务：
 * 1. 理解 @SpringBootApplication 的组成（@SpringBootConfiguration + @EnableAutoConfiguration + @ComponentScan）
 * 2. 理解 @MapperScan：告诉 Spring 去哪里扫描 Mapper 接口。不写会怎样？
 * 3. 启动成功后访问 http://localhost:8123/api/doc.html 看接口文档
 */
@SpringBootApplication
@MapperScan("com.kai.kaipicturebackend.mapper")
public class KaiPictureBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(KaiPictureBackendApplication.class, args);
    }
}
