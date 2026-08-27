package com.kai.kaipicturebackend.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kai.kaipicturebackend.annotation.AuthCheck;
import com.kai.kaipicturebackend.common.BaseResponse;
import com.kai.kaipicturebackend.common.DeleteRequest;
import com.kai.kaipicturebackend.common.ErrorCode;
import com.kai.kaipicturebackend.common.ResultUtils;
import com.kai.kaipicturebackend.constant.UserConstant;
import com.kai.kaipicturebackend.exception.BusinessException;
import com.kai.kaipicturebackend.model.dto.user.UserLoginRequest;
import com.kai.kaipicturebackend.model.dto.user.UserQueryRequest;
import com.kai.kaipicturebackend.model.dto.user.UserRegisterRequest;
import com.kai.kaipicturebackend.model.dto.user.UserUpdateRequest;
import com.kai.kaipicturebackend.model.entity.User;
import com.kai.kaipicturebackend.model.vo.LoginUserVO;
import com.kai.kaipicturebackend.model.vo.UserVO;
import com.kai.kaipicturebackend.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 用户接口 —— 第 3 期任务。
 *
 * 接口清单（先自己设计一遍再对照）：
 * POST   /user/register     注册（所有人）
 * POST   /user/login        登录（所有人）
 * POST   /user/logout       注销（登录用户）
 * GET    /user/get/login    获取当前登录用户（登录用户）
 * GET    /user/get          根据 id 查询用户（登录用户）
 * POST   /user/list/page    用户分页查询（管理员）
 * POST   /user/update       更新用户（管理员）
 * POST   /user/delete       删除用户（管理员）
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    /**
     * 用户注册
     */
    @PostMapping("/register")
    public BaseResponse<Long> userRegister(@RequestBody UserRegisterRequest userRegisterRequest) {
        if (userRegisterRequest == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        String userAccount = userRegisterRequest.getUserAccount();
        String userPassword = userRegisterRequest.getUserPassword();
        String checkPassword = userRegisterRequest.getCheckPassword();
        // TODO 第 3 期：判空校验 + 调 userService.userRegister
        long result = userService.userRegister(userAccount, userPassword, checkPassword);
        return ResultUtils.success(result);
    }

    /**
     * 用户登录
     */
    @PostMapping("/login")
    public BaseResponse<LoginUserVO> userLogin(@RequestBody UserLoginRequest userLoginRequest,
                                               HttpServletRequest request) {
        // TODO 第 3 期：实现（参考 register 的校验写法）
        return null;
    }

    /**
     * 用户注销
     */
    @PostMapping("/logout")
    public BaseResponse<Boolean> userLogout(HttpServletRequest request) {
        // TODO 第 3 期：实现
        return null;
    }

    /**
     * 获取当前登录用户
     */
    @GetMapping("/get/login")
    public BaseResponse<LoginUserVO> getLoginUser(HttpServletRequest request) {
        // TODO 第 3 期：实现
        // 提示：userService.getLoginUser(request) 拿 User → getLoginUserVO 脱敏 → success
        return null;
    }

    /**
     * 根据 id 获取用户（管理员用，返回脱敏 VO）
     */
    @GetMapping("/get")
    public BaseResponse<UserVO> getUserById(long id, HttpServletRequest request) {
        // TODO 第 3 期：实现（校验 id > 0，查用户，转 VO）
        return null;
    }

    /**
     * 用户分页查询（管理员）
     */
    @PostMapping("/list/page")
    @AuthCheck(mustRole = UserConstant.ADMIN_ROLE)
    public BaseResponse<Page<UserVO>> listUserVOByPage(@RequestBody UserQueryRequest userQueryRequest) {
        // TODO 第 3 期：实现
        // 提示：
        // 1. 校验请求非空
        // 2. long current = userQueryRequest.getCurrent(); long size = userQueryRequest.getPageSize();
        // 3. QueryWrapper 用 userService.getQueryWrapper(userQueryRequest)
        // 4. this 分页：userService.page(new Page<>(current, size), queryWrapper)
        // 5. 转 VO 分页：new Page<>(current, size, total) + getUserVOList
        // 6. 注意：MyBatis-Plus 分页查询返回 total 后，要手动设置到 VO 分页里
        return null;
    }

    /**
     * 更新用户（管理员）
     */
    @PostMapping("/update")
    @AuthCheck(mustRole = UserConstant.ADMIN_ROLE)
    public BaseResponse<Boolean> updateUser(@RequestBody UserUpdateRequest userUpdateRequest) {
        // TODO 第 3 期：实现（校验 id 非空 → 组装 User → userService.updateById）
        return null;
    }

    /**
     * 删除用户（管理员）
     */
    @PostMapping("/delete")
    @AuthCheck(mustRole = UserConstant.ADMIN_ROLE)
    public BaseResponse<Boolean> deleteUser(@RequestBody DeleteRequest deleteRequest) {
        // TODO 第 3 期：实现（校验 id → userService.removeById）
        return null;
    }
}
