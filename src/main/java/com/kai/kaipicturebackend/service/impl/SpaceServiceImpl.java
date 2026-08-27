package com.kai.kaipicturebackend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kai.kaipicturebackend.mapper.SpaceMapper;
import com.kai.kaipicturebackend.model.dto.space.SpaceAddRequest;
import com.kai.kaipicturebackend.model.dto.space.SpaceQueryRequest;
import com.kai.kaipicturebackend.model.entity.Space;
import com.kai.kaipicturebackend.model.entity.User;
import com.kai.kaipicturebackend.model.enums.SpaceLevelEnum;
import com.kai.kaipicturebackend.model.vo.SpaceVO;
import com.kai.kaipicturebackend.service.SpaceService;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * 空间服务实现 —— 第 7 期核心任务。
 *
 * 三个核心点（面试必问）：
 * 1. 开通空间的校验逻辑（数量上限？重复开通？）
 * 2. 限额怎么填充、怎么校验
 * 3. 空间权限体系（谁是这个空间的主人）
 */
@Service
public class SpaceServiceImpl extends ServiceImpl<SpaceMapper, Space>
        implements SpaceService {

    /**
     * 用户最多创建的空间数量（私有空间，第 7 期）
     */
    private static final long MAX_PRIVATE_SPACE_COUNT = 1L;

    @Override
    public long addSpace(SpaceAddRequest spaceAddRequest, User loginUser) {
        // TODO 第 7 期：实现开通空间，流程：
        // 1. 校验参数（spaceName 非空、spaceLevel 有效）
        // 2. 校验用户已有私有空间数量 < MAX_PRIVATE_SPACE_COUNT
        //    （count 一下 space 表 where userId = 登录用户 and spaceType = 私有）
        // 3. 组装 Space：fillSpaceBySpaceLevel 填充限额
        // 4. save 返回 id
        // 思考：一个用户能开多个私有空间吗？教程怎么设计的？为什么？
        return 0;
    }

    @Override
    public void validSpace(Space space, boolean add) {
        // TODO 第 7 期：实现数据校验
        // - 空间名非空且 <= 30 字符
        // - 级别枚举存在
        // - add 时校验默认级别
    }

    @Override
    public void fillSpaceBySpaceLevel(Space space) {
        // TODO 第 7 期：实现按级别填充额度
        // 提示：SpaceLevelEnum.getEnumByValue(space.getSpaceLevel())，
        // 把 maxSize / maxCount 设置成枚举里的值
        // 思考：为什么用枚举存额度，而不是配置文件/数据库表？
    }

    @Override
    public SpaceVO getSpaceVO(Space space, HttpServletRequest request) {
        // TODO 第 7 期：空间转 VO（组装 userName）
        return null;
    }

    @Override
    public QueryWrapper<Space> getQueryWrapper(SpaceQueryRequest spaceQueryRequest) {
        // TODO 第 7 期：动态查询条件（spaceName 模糊、spaceLevel 精确、userId 精确）
        return null;
    }

    @Override
    public void checkSpaceAuth(Space space, User loginUser) {
        // TODO 第 7 期：实现空间权限校验
        // 规则：空间创建者 或 系统管理员 才能操作空间
        // 第 11 期：团队空间还要允许"空间管理员"（看 space_user 表）
        // 思考：为什么权限校验要抽成公共方法？哪些接口要用它？
    }
}
