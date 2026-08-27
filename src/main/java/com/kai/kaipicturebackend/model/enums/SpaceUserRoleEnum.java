package com.kai.kaipicturebackend.model.enums;

import org.springframework.util.ObjectUtils;

/**
 * 空间成员角色枚举（团队空间内）。
 *
 * 第 11 期任务：
 * 1. 理解"系统角色"（UserRoleEnum：user/admin）和"空间角色"（本枚举）的区别：
 *    - 系统角色管整个平台
 *    - 空间角色只管某个空间内能干什么
 * 2. 思考：空间管理员能不能管理空间内的成员？空间创建者是什么角色？
 */
public enum SpaceUserRoleEnum {

    SPACE_USER("普通成员", "user"),
    SPACE_ADMIN("空间管理员", "admin");

    private final String text;

    private final String value;

    SpaceUserRoleEnum(String text, String value) {
        this.text = text;
        this.value = value;
    }

    public static SpaceUserRoleEnum getEnumByValue(String value) {
        if (ObjectUtils.isEmpty(value)) {
            return null;
        }
        for (SpaceUserRoleEnum anEnum : SpaceUserRoleEnum.values()) {
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
