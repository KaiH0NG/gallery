package com.kai.kaipicturebackend.aop;

import com.kai.kaipicturebackend.annotation.AuthCheck;
import com.kai.kaipicturebackend.common.ErrorCode;
import com.kai.kaipicturebackend.exception.BusinessException;
import com.kai.kaipicturebackend.model.entity.User;
import com.kai.kaipicturebackend.model.enums.UserRoleEnum;
import com.kai.kaipicturebackend.service.UserService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 权限校验切面 —— 拦截所有带 @AuthCheck 注解的方法，执行权限校验。
 *
 * 工作流程（第 3 期任务，要能讲出来）：
 * 1. 拿到方法上的 @AuthCheck 注解，读取 mustRole
 * 2. 从 request 中获取当前登录用户
 * 3. mustRole 为空 → 只需登录；不为空 → 必须匹配指定角色
 * 4. 校验失败抛 BusinessException，由全局异常处理器返回
 *
 * 思考：
 * - 为什么不直接在每个 controller 方法里写 if 判断？（重复代码、易遗漏）
 * - AOP 的"切面"是什么？"环绕通知 @Around"和"前置通知 @Before"的区别？
 */
@Aspect
@Component
public class AuthInterceptor {

    @Resource
    private UserService userService;

    /**
     * 环绕通知：拦截所有标注了 @AuthCheck 的方法
     */
    @Around("@annotation(authCheck)")
    public Object doInterceptor(ProceedingJoinPoint joinPoint, AuthCheck authCheck) throws Throwable {
        // 1. 获取请求对象
        RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();

        // 2. 获取当前登录用户（TODO 第 3 期：userService.getLoginUser 实现后这里才能工作）
        User loginUser = userService.getLoginUser(request);

        // 3. 校验角色
        String mustRole = authCheck.mustRole();
        UserRoleEnum mustRoleEnum = UserRoleEnum.getEnumByValue(mustRole);
        // 不需要权限，直接放行
        if (mustRoleEnum == null) {
            return joinPoint.proceed();
        }
        // 需要权限：先校验是否已登录
        if (loginUser == null) {
            throw new BusinessException(ErrorCode.NOT_LOGIN_ERROR);
        }
        // 管理员校验
        if (UserRoleEnum.ADMIN.equals(mustRoleEnum)) {
            if (!UserRoleEnum.ADMIN.getValue().equals(loginUser.getUserRole())) {
                throw new BusinessException(ErrorCode.NO_AUTH_ERROR);
            }
        }
        // 校验通过，放行原方法
        return joinPoint.proceed();
    }
}
