package com.kai.kaipicturebackend.websocket.model;

import lombok.Data;

import java.io.Serializable;

/**
 * 图片编辑请求消息（前端 → 后端，第 12 期 WebSocket）。
 *
 * 第 12 期任务：
 * 1. 理解消息协议：WebSocket 传输的是 JSON 字符串，
 *    前端发来的消息统一用这个类接收
 * 2. type：消息类型（INFO/ERROR/ENTER_EDIT/EXIT_EDIT/EDIT_ACTION）
 * 3. editAction：编辑动作类型（画了什么，如画线/橡皮擦）
 * 4. editContext：编辑内容（JSON 字符串，比如线条的坐标数组）
 */
@Data
public class PictureEditRequestMessage implements Serializable {

    /**
     * 消息类型（PictureEditMessageTypeEnum）
     */
    private String type;

    /**
     * 编辑操作类型（如 DRAW / ERASER 等）
     */
    private String editAction;

    /**
     * 图片 id
     */
    private Long pictureId;

    /**
     * 编辑内容（JSON 字符串）
     */
    private String editContext;

    private static final long serialVersionUID = 1L;
}
