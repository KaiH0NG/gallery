package com.kai.kaipicturebackend.model.enums;

import org.springframework.util.ObjectUtils;

/**
 * 用户角色枚举。
 *
 * 第 3 期任务：
 * 1. 理解枚举的作用：把"user / admin"这些魔法字符串集中管理
 * 2. 理解 getEnumByValue：根据值找枚举（解析前端传参/数据库值时用）
 * 3. 扩展：以后加会员角色，只需在这里加一个枚举值
 */
public enum UserRoleEnum {

    USER("用户", "user"),
    ADMIN("管理员", "admin");

    /**
     * 展示文本
     */
    private final String text;

    /**
     * 实际值（存数据库的值）
     */
    private final String value;

    UserRoleEnum(String text, String value) {
        this.text = text;
        this.value = value;
    }

    /**
     * 根据 value 获取枚举
     */
    public static UserRoleEnum getEnumByValue(String value) {
        if (ObjectUtils.isEmpty(value)) {
            return null;
        }
        for (UserRoleEnum anEnum : UserRoleEnum.values()) {
            if (anEnum.value.equals(value)) {
                return anEnum;
            }
        }
        return null;
    }

    public String getText() {
        return text;
    }

    public String getValue() {
        return value;
    }
}
