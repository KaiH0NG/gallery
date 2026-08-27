package com.kai.kaipicturebackend.model.enums;

import org.springframework.util.ObjectUtils;

/**
 * 图片协同编辑消息类型枚举（第 12 期）。
 *
 * WebSocket 通信时，消息要区分"类型"，服务端才能决定怎么处理：
 * - INFO：进入/退出编辑等状态通知
 * - ERROR：错误信息
 * - ENTER_EDIT：请求进入编辑
 * - EXIT_EDIT：退出编辑
 * - EDIT_ACTION：编辑动作（画了什么、改了什么）
 *
 * 第 12 期任务：了解消息协议的设计思路，先不用全部实现
 */
public enum PictureEditMessageTypeEnum {

    INFO("发送通知", "INFO"),
    ERROR("发送错误", "ERROR"),
    ENTER_EDIT("进入编辑状态", "ENTER_EDIT"),
    EXIT_EDIT("退出编辑状态", "EXIT_EDIT"),
    EDIT_ACTION("执行编辑操作", "EDIT_ACTION");

    private final String text;

    private final String value;

    PictureEditMessageTypeEnum(String text, String value) {
        this.text = text;
        this.value = value;
    }

    public static PictureEditMessageTypeEnum getEnumByValue(String value) {
        if (ObjectUtils.isEmpty(value)) {
            return null;
        }
        for (PictureEditMessageTypeEnum anEnum : PictureEditMessageTypeEnum.values()) {
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
