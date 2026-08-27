-- ========== 用户表（第 3 期）==========
-- 这是完整示例：参考它的写法，完成 02-picture.sql 和 03-space.sql
-- 学习点：
-- 1. 为什么 id 用 bigint？为什么不用自增？（MyBatis-Plus ASSIGN_ID 雪花算法）
-- 2. 为什么 userAccount 加 UNIQUE KEY？（数据库层面防重复）
-- 3. 为什么有 editTime / createTime / updateTime 三个时间？
-- 4. 为什么有 isDelete？（逻辑删除）

CREATE TABLE IF NOT EXISTS user (
    id            BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT 'id',
    userAccount   VARCHAR(256) NOT NULL COMMENT '账号',
    userPassword  VARCHAR(512) NOT NULL COMMENT '密码（加密存储）',
    userName      VARCHAR(256) NULL COMMENT '用户昵称',
    userAvatar    VARCHAR(1024) NULL COMMENT '用户头像',
    userProfile   VARCHAR(512) NULL COMMENT '用户简介',
    userRole      VARCHAR(256) DEFAULT 'user' NOT NULL COMMENT '用户角色：user/admin',
    editTime      DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL COMMENT '编辑时间',
    createTime    DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL COMMENT '创建时间',
    updateTime    DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP NOT NULL COMMENT '更新时间',
    isDelete      TINYINT DEFAULT 0 NOT NULL COMMENT '是否删除',
    UNIQUE KEY uk_userAccount (userAccount),
    INDEX idx_userName (userName)
) COMMENT '用户';
