package com.kai.kaipicturebackend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kai.kaipicturebackend.model.entity.SpaceUser;

/**
 * 空间成员服务接口（第 11 期，团队空间）。
 *
 * 第 11 期任务（请参考 PDF 版教程，h5 版第 11 期内容有误）：
 * - 添加成员：邀请用户加入团队空间
 * - 成员管理：分页查询成员、移除成员、修改成员角色
 * - 权限校验：谁能加人？（空间创建者 / 空间管理员）
 * - 第 12 期：协同编辑时校验"是否空间成员"
 */
public interface SpaceUserService extends IService<SpaceUser> {

    // TODO 第 11 期：定义方法
    // 参考：
    // SpaceUserVO getSpaceUserVO(SpaceUser spaceUser);
    // List<SpaceUserVO> getSpaceUserVOList(List<SpaceUser> spaceUserList);
    // void checkSpaceUserAuth(SpaceUser spaceUser, User loginUser);
}
