package com.kai.kaipicturebackend.controller;

import com.kai.kaipicturebackend.common.BaseResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 空间成员接口 —— 第 11 期（团队空间）。
 *
 * ⚠️ 注意：本地 h5 教程第 11 期文件内容有误（是第 10 期图库分析的重复），
 * 请使用 PDF 版：`项目总览/PDF/11 - 团队空间.pdf`
 *
 * 参考接口清单（先自己设计再对照）：
 * POST   /spaceUser/add        添加成员（空间创建者/管理员）
 * GET    /spaceUser/get        获取成员信息
 * POST   /spaceUser/list/page  成员分页（空间内）
 * POST   /spaceUser/delete     移除成员
 * POST   /spaceUser/update     修改成员角色
 */
@RestController
@RequestMapping("/spaceUser")
public class SpaceUserController {

    @Resource
    private com.kai.kaipicturebackend.service.SpaceUserService spaceUserService;

    // TODO 第 11 期：补全接口
}
