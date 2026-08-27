package com.kai.kaipicturebackend.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kai.kaipicturebackend.annotation.AuthCheck;
import com.kai.kaipicturebackend.common.BaseResponse;
import com.kai.kaipicturebackend.common.DeleteRequest;
import com.kai.kaipicturebackend.common.ErrorCode;
import com.kai.kaipicturebackend.common.ResultUtils;
import com.kai.kaipicturebackend.constant.UserConstant;
import com.kai.kaipicturebackend.exception.BusinessException;
import com.kai.kaipicturebackend.model.dto.space.SpaceAddRequest;
import com.kai.kaipicturebackend.model.dto.space.SpaceEditRequest;
import com.kai.kaipicturebackend.model.dto.space.SpaceQueryRequest;
import com.kai.kaipicturebackend.model.dto.space.SpaceUpdateRequest;
import com.kai.kaipicturebackend.model.entity.User;
import com.kai.kaipicturebackend.model.vo.SpaceVO;
import com.kai.kaipicturebackend.service.SpaceService;
import com.kai.kaipicturebackend.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 空间接口 —— 第 7 期任务。
 *
 * 接口清单（先自己设计再对照）：
 * POST   /space/add         开通空间（登录用户）
 * GET    /space/get         获取空间详情（本人或管理员）
 * POST   /space/list/page   空间分页（管理员）
 * POST   /space/update      更新空间（管理员）
 * POST   /space/edit        编辑空间（空间创建者）
 * POST   /space/delete      删除空间（本人或管理员）
 */
@RestController
@RequestMapping("/space")
public class SpaceController {

    @Resource
    private SpaceService spaceService;

    @Resource
    private UserService userService;

    /**
     * 开通空间
     */
    @PostMapping("/add")
    public BaseResponse<Long> addSpace(@RequestBody SpaceAddRequest spaceAddRequest,
                                       HttpServletRequest request) {
        // TODO 第 7 期：实现
        return null;
    }

    /**
     * 获取空间详情
     */
    @GetMapping("/get")
    public BaseResponse<SpaceVO> getSpaceVOById(long id, HttpServletRequest request) {
        // TODO 第 7 期：实现
        // 注意：需要校验空间权限（私有的空间别人不能看）
        return null;
    }

    /**
     * 空间分页（管理员）
     */
    @PostMapping("/list/page")
    @AuthCheck(mustRole = UserConstant.ADMIN_ROLE)
    public BaseResponse<Page<SpaceVO>> listSpaceVOByPage(@RequestBody SpaceQueryRequest spaceQueryRequest) {
        // TODO 第 7 期：实现（参考用户分页）
        return null;
    }

    /**
     * 更新空间（管理员）
     */
    @PostMapping("/update")
    @AuthCheck(mustRole = UserConstant.ADMIN_ROLE)
    public BaseResponse<Boolean> updateSpace(@RequestBody SpaceUpdateRequest spaceUpdateRequest) {
        // TODO 第 7 期：实现
        return null;
    }

    /**
     * 编辑空间（空间创建者）
     */
    @PostMapping("/edit")
    public BaseResponse<Boolean> editSpace(@RequestBody SpaceEditRequest spaceEditRequest,
                                           HttpServletRequest request) {
        // TODO 第 7 期：实现
        return null;
    }

    /**
     * 删除空间
     */
    @PostMapping("/delete")
    public BaseResponse<Boolean> deleteSpace(@RequestBody DeleteRequest deleteRequest,
                                             HttpServletRequest request) {
        // TODO 第 7 期：实现
        // 思考：空间里的图片怎么办？删空间 = 删图片吗？
        return null;
    }
}
