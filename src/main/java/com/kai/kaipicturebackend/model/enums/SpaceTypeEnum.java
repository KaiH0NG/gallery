package com.kai.kaipicturebackend.model.enums;

import org.springframework.util.ObjectUtils;

/**
 * 空间类型枚举。
 *
 * 第 11 期任务（本地 h5 教程第 11 期文件有误，请参考 PDF 版）：
 * 1. 理解私有空间和团队空间的区别：
 *    - 私有空间：只能自己用，不需要成员表
 *    - 团队空间：可以邀请成员，需要 space_user 成员表
 * 2. 思考：图片属于空间，空间类型变了会影响什么？
 */
public enum SpaceTypeEnum {

    PRIVATE("私有空间", 0),
    TEAM("团队空间", 1);

    private final String text;

    private final int value;

    SpaceTypeEnum(String text, int value) {
        this.text = text;
        this.value = value;
    }

    public static SpaceTypeEnum getEnumByValue(Integer value) {
        if (ObjectUtils.isEmpty(value)) {
            return null;
        }
        for (SpaceTypeEnum anEnum : SpaceTypeEnum.values()) {
            if (anEnum.value == value) {
                return anEnum;
            }
        }
        return null;
    }

    public String getText() {
        return text;
    }

    public int getValue() {
        return value;
    }
}
