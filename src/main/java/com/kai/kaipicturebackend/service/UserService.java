package com.kai.kaipicturebackend.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.kai.kaipicturebackend.model.dto.user.UserQueryRequest;
import com.kai.kaipicturebackend.model.entity.User;
import com.kai.kaipicturebackend.model.vo.LoginUserVO;
import com.kai.kaipicturebackend.model.vo.UserVO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 用户服务接口。
 *
 * 第 3 期任务：
 * 1. 理解为什么接口 + 实现类两层？
 *    （面向接口编程：好替换、好测试、好扩展；MyBatis-Plus 的 IService 也自带通用 CRUD）
 * 2. 每个方法的实现要点都写在 Impl 里了
 */
public interface UserService extends IService<User> {

    /**
     * 用户注册
     */
    long userRegister(String userAccount, String userPassword, String checkPassword);

    /**
     * 用户登录
     */
    LoginUserVO userLogin(String userAccount, String userPassword, HttpServletRequest request);

    /**
     * 获取当前登录用户（从 session 取）
     */
    User getLoginUser(HttpServletRequest request);

    /**
     * 获取脱敏后的登录用户信息
     */
    LoginUserVO getLoginUserVO(User user);

    /**
     * 用户注销
     */
    boolean userLogout(HttpServletRequest request);

    /**
     * 获取脱敏后的用户信息
     */
    UserVO getUserVO(User user);

    /**
     * 获取脱敏后的用户列表
     */
    List<UserVO> getUserVOList(List<User> userList);

    /**
     * 判断当前用户是否为管理员
     */
    boolean isAdmin(HttpServletRequest request);

    /**
     * 判断指定用户是否为管理员
     */
    boolean isAdmin(User user);

    /**
     * 根据查询条件构造 QueryWrapper（动态 SQL）
     */
    QueryWrapper<User> getQueryWrapper(UserQueryRequest userQueryRequest);
}
