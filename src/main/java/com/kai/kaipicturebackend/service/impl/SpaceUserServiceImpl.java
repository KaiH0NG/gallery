package com.kai.kaipicturebackend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kai.kaipicturebackend.mapper.SpaceUserMapper;
import com.kai.kaipicturebackend.model.entity.SpaceUser;
import com.kai.kaipicturebackend.service.SpaceUserService;
import org.springframework.stereotype.Service;

/**
 * 空间成员服务实现 —— 第 11 期（团队空间）。
 *
 * ⚠️ 注意：本地 h5 教程第 11 期文件内容有误（是第 10 期图库分析的重复），
 * 请使用 PDF 版：`项目总览/PDF/11 - 团队空间.pdf`
 *
 * 第 11 期任务（先看教程再写）：
 * 1. 添加成员：校验空间类型是团队 → 校验邀请人权限（创建者/空间管理员）
 *    → 查用户存在 → 保存成员关系
 * 2. 删除成员：不能删自己？不能删创建者？（设计好规则）
 * 3. 修改成员角色：空间管理员可以管理普通成员
 * 4. 校验空间成员权限：图片协同编辑（第 12 期）时，非成员不能编辑
 */
@Service
public class SpaceUserServiceImpl extends ServiceImpl<SpaceUserMapper, SpaceUser>
        implements SpaceUserService {
}
