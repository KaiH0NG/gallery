# backend · 后端代码骨架（Spring Boot）

> 这是按教程真实结构搭的**引导式骨架**：
> - 基础设施类（统一响应、异常、配置、权限注解）→ 给你完整实现，作为"标准写法"范例
> - 业务类（Service 实现、Controller 方法体）→ 全部留白，按 TODO 引导自己填
>
> 对应教程第 2 期（项目初始化）～ 第 14 期（部署上线）。

## 怎么开始（第 2 期）

1. 用 IDEA 打开本目录，等待 Maven 下载依赖
2. 修改 `src/main/resources/application.yml` 里的数据库账号密码
3. 启动 `KaiPictureBackendApplication`，访问 http://localhost:8123/api/doc.html 看接口文档
4. 从 `controller` 里的 TODO 开始，一个模块一个模块填

## 目录结构（真实项目分层）

```
backend/
├── pom.xml                        # 依赖管理（后阶段依赖已注释，用到再加）
├── sql/                           # 建表 SQL（第 3 期开始写）
└── src/main/
    ├── java/com/kai/kaipicturebackend/
    │   ├── KaiPictureBackendApplication.java   # 启动类
    │   ├── common/        # 通用：统一响应 / 错误码 / 分页请求 / 工具
    │   ├── exception/     # 业务异常 + 全局异常处理
    │   ├── config/        # 配置：跨域 / MyBatis-Plus / COS
    │   ├── annotation/    # 自定义注解（权限校验）
    │   ├── aop/           # 切面（权限校验实现）
    │   ├── constant/      # 常量
    │   ├── enums/         # 枚举（角色 / 审核状态 / 空间级别 / 消息类型）
    │   ├── manager/       # 通用能力：COS 操作 / 文件上传
    │   ├── model/         # entity 实体 / dto 请求 / vo 响应
    │   ├── service/       # 业务层（接口 + impl）
    │   ├── controller/    # 接口层（薄）
    │   └── websocket/     # 第 12 期：协同编辑
    └── resources/
        ├── application.yml         # 项目配置
        └── mapper/                 # MyBatis XML（自定义 SQL）
```

## 分层职责（面试要能讲）

| 层 | 职责 | 口诀 |
| --- | --- | --- |
| controller | 收参数、调 service、返回结果 | 薄 |
| service | 业务逻辑、权限、事务 | 厚（核心） |
| mapper | SQL 操作 | 只做数据访问 |
| model/entity | 数据库实体 | 对应表 |
| model/dto | 前端传参 | 按请求定义 |
| model/vo | 返回给前端 | 脱敏、组装 |

## 学习顺序

1. 第 2 期：让项目跑起来（改配置、启动、访问接口文档）
2. 第 3 期：common / exception 看一遍（已实现），然后填 UserServiceImpl
3. 之后每期：先看 TODO 引导 → 自己实现 → 对照源码
