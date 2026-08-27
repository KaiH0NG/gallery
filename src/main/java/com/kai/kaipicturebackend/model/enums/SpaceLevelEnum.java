package com.kai.kaipicturebackend.model.enums;

import org.springframework.util.ObjectUtils;

/**
 * 空间级别枚举 —— 决定空间的大小额度。
 *
 * 第 7 期任务：
 * 1. 思考：为什么额度不写死在代码里，而是每个枚举带 maxCount/maxSize？
 *    （提示：换一套额度方案只需改枚举，而且教程还允许管理员单独修改空间限额）
 * 2. TODO：查教程第 7 期，把普通版/专业版/旗舰版的额度数值填进来
 *    （maxCount 单位：张；maxSize 单位：字节，1MB = 1024 * 1024）
 */
public enum SpaceLevelEnum {

    COMMON("普通版", 0, 0L, 0L),
    PROFESSIONAL("专业版", 1, 0L, 0L),
    FLAGSHIP("旗舰版", 2, 0L, 0L);

    /**
     * 展示文本
     */
    private final String text;

    /**
     * 级别值（存数据库）
     */
    private final int value;

    /**
     * 最大图片数量
     */
    private final long maxCount;

    /**
     * 最大总大小（字节）
     */
    private final long maxSize;

    SpaceLevelEnum(String text, int value, long maxCount, long maxSize) {
        this.text = text;
        this.value = value;
        this.maxCount = maxCount;
        this.maxSize = maxSize;
    }

    /**
     * 根据 value 获取枚举
     */
    public static SpaceLevelEnum getEnumByValue(Integer value) {
        if (ObjectUtils.isEmpty(value)) {
            return null;
        }
        for (SpaceLevelEnum anEnum : SpaceLevelEnum.values()) {
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

    public long getMaxCount() {
        return maxCount;
    }

    public long getMaxSize() {
        return maxSize;
    }
}
