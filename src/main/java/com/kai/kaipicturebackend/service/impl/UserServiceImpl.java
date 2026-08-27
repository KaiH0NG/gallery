package com.kai.kaipicturebackend.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kai.kaipicturebackend.common.ErrorCode;
import com.kai.kaipicturebackend.constant.UserConstant;
import com.kai.kaipicturebackend.exception.BusinessException;
import com.kai.kaipicturebackend.mapper.UserMapper;
import com.kai.kaipicturebackend.model.dto.user.UserQueryRequest;
import com.kai.kaipicturebackend.model.entity.User;
import com.kai.kaipicturebackend.model.enums.UserRoleEnum;
import com.kai.kaipicturebackend.model.vo.LoginUserVO;
import com.kai.kaipicturebackend.model.vo.UserVO;
import com.kai.kaipicturebackend.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 用户服务实现 —— 第 3 期核心任务，按顺序完成下面 6 步。
 *
 * 每一步做完都跑一次测试（Knife4j 接口文档里调接口），再进下一步。
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
        implements UserService {

    /**
     * 密码加盐常量（思考：为什么加盐？直接用 MD5 有什么风险？）
     */
    private static final String SALT = "kai";

    @Override
    public long userRegister(String userAccount, String userPassword, String checkPassword) {
        // TODO 第 3 期 第 1 步：实现注册，流程：
        // 1. 参数校验（用 StrUtil.hasBlank / ThrowUtils 或抛 BusinessException）：
        //    - 账号、密码、确认密码都不能为空
        //    - 账号长度 >= 4
        //    - 密码长度 >= 8
        //    - 两次密码一致
        // 2. 检查账号是否已存在：
        //    QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        //    queryWrapper.eq("userAccount", userAccount);
        //    long count = this.count(queryWrapper);
        //    if (count > 0) throw new BusinessException(ErrorCode.PARAMS_ERROR, "账号已存在");
        // 3. 密码加密：DigestUtils.md5DigestAsHex((SALT + userPassword).getBytes())
        // 4. 插入用户：设置 userAccount / userPassword(加密后) / userName("用户" + 随机数) /
        //              userRole(UserRoleEnum.USER.getValue())
        // 5. save(user) 成功后返回 user.getId()
        return 0;
    }

    @Override
    public LoginUserVO userLogin(String userAccount, String userPassword, HttpServletRequest request) {
        // TODO 第 3 期 第 2 步：实现登录，流程：
        // 1. 参数校验（账号密码非空、账号长度 >= 4）
        // 2. 按账号查询用户（注意：查出来的密码是密文）
        // 3. 校验用户存在 + 密码一致（把输入的密码同样加密后比对）
        // 4. 把用户信息存到 session：
        //    request.getSession().setAttribute(UserConstant.USER_LOGIN_STATE, user);
        // 5. 返回 getLoginUserVO(user)（脱敏！绝不能返回带密码的对象）
        return null;
    }

    @Override
    public User getLoginUser(HttpServletRequest request) {
        // TODO 第 3 期 第 3 步：实现获取当前登录用户，流程：
        // 1. 从 session 取：request.getSession().getAttribute(UserConstant.USER_LOGIN_STATE)
        // 2. 取不到 → throw new BusinessException(ErrorCode.NOT_LOGIN_ERROR)
        // 3. 能取到 → 查数据库拿最新数据（为什么不直接用 session 里的？
        //    因为 session 里的可能是旧数据，比如管理员改了角色）
        // 4. 数据库查不到 → 也抛未登录异常（用户可能已被删除）
        return null;
    }

    @Override
    public LoginUserVO getLoginUserVO(User user) {
        if (user == null) {
            return null;
        }
        LoginUserVO loginUserVO = new LoginUserVO();
        // TODO 第 3 期：BeanUtils.copyProperties(user, loginUserVO)
        // 思考：copyProperties 会复制 userPassword 吗？（LoginUserVO 没有该字段 → 不会）
        return loginUserVO;
    }

    @Override
    public boolean userLogout(HttpServletRequest request) {
        // TODO 第 3 期 第 4 步：实现注销
        // 提示：request.getSession().removeAttribute(UserConstant.USER_LOGIN_STATE)
        return true;
    }

    @Override
    public UserVO getUserVO(User user) {
        if (user == null) {
            return null;
        }
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(user, userVO);
        return userVO;
    }

    @Override
    public List<UserVO> getUserVOList(List<User> userList) {
        // TODO 第 3 期：把列表逐条转 VO
        // 提示：userList.stream().map(this::getUserVO).collect(Collectors.toList())
        return null;
    }

    @Override
    public boolean isAdmin(HttpServletRequest request) {
        // TODO 第 3 期：从 session 取用户，判断角色是否为管理员
        // 提示：参考 getLoginUser 的实现
        return false;
    }

    @Override
    public boolean isAdmin(User user) {
        // TODO 第 3 期：直接判断 user.getUserRole() 是否等于 UserRoleEnum.ADMIN.getValue()
        return false;
    }

    @Override
    public QueryWrapper<User> getQueryWrapper(UserQueryRequest userQueryRequest) {
        // TODO 第 3 期 第 5 步：实现动态条件查询，流程：
        // 1. 参数校验（userQueryRequest 为空抛参数错误）
        // 2. 取出条件：userName / userRole
        // 3. 拼条件：
        //    QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        //    queryWrapper.like(StrUtil.isNotBlank(userName), "userName", userName);
        //    queryWrapper.eq(StrUtil.isNotBlank(userRole), "userRole", userRole);
        // 4. 排序（按创建时间倒序）
        // 思考：like 和 eq 的区别？空条件为什么用 isNotBlank 判断？
        return null;
    }
}
