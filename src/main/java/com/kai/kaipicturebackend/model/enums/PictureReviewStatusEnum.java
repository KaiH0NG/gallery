package com.kai.kaipicturebackend.model.enums;

import org.springframework.util.ObjectUtils;

/**
 * 图片审核状态枚举。
 *
 * 第 5 期任务：
 * 1. 理解为什么审核状态用整数（0/1/2）而不是字符串（节约空间、查询更快）
 * 2. 理解状态流转：
 *    上传/编辑 → 待审核(0) → 管理员审核 → 通过(1) 或 拒绝(2)
 * 3. 注意：状态流转要画出来，这是面试常问的"状态机"思维
 */
public enum PictureReviewStatusEnum {

    REVIEWING("待审核", 0),
    PASS("通过", 1),
    REJECT("拒绝", 2);

    private final String text;

    private final int value;

    PictureReviewStatusEnum(String text, int value) {
        this.text = text;
        this.value = value;
    }

    /**
     * 根据 value 获取枚举
     */
    public static PictureReviewStatusEnum getEnumByValue(Integer value) {
        if (ObjectUtils.isEmpty(value)) {
            return null;
        }
        for (PictureReviewStatusEnum anEnum : PictureReviewStatusEnum.values()) {
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
