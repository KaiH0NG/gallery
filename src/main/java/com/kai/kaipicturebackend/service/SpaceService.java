package com.kai.kaipicturebackend.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.kai.kaipicturebackend.model.dto.space.SpaceAddRequest;
import com.kai.kaipicturebackend.model.dto.space.SpaceQueryRequest;
import com.kai.kaipicturebackend.model.entity.Space;
import com.kai.kaipicturebackend.model.entity.User;
import com.kai.kaipicturebackend.model.vo.SpaceVO;

import javax.servlet.http.HttpServletRequest;

/**
 * 空间服务接口（第 7 期）。
 *
 * 核心难点（面试重点）：
 * 1. 空间权限：谁能操作这个空间？（创建者 / 空间管理员 / 系统管理员）
 * 2. 限额控制：上传图片时怎么判断空间满了？（totalSize/totalCount 的维护）
 * 3. 第 11 期：团队空间 + 成员管理（见 SpaceUserService）
 */
public interface SpaceService extends IService<Space> {

    /**
     * 开通空间
     */
    long addSpace(SpaceAddRequest spaceAddRequest, User loginUser);

    /**
     * 空间数据校验
     */
    void validSpace(Space space, boolean add);

    /**
     * 根据空间级别填充额度（maxSize/maxCount）
     */
    void fillSpaceBySpaceLevel(Space space);

    /**
     * 获取空间 VO
     */
    SpaceVO getSpaceVO(Space space, HttpServletRequest request);

    /**
     * 分页获取空间 VO（第 11 期会调整）
     */
    // Page<SpaceVO> getSpaceVOPage(Page<Space> spacePage, HttpServletRequest request);

    /**
     * 构造查询条件
     */
    QueryWrapper<Space> getQueryWrapper(SpaceQueryRequest spaceQueryRequest);

    /**
     * 校验空间权限（谁能操作这个空间）
     */
    void checkSpaceAuth(Space space, User loginUser);
}
