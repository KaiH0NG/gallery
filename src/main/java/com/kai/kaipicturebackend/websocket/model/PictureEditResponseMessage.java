package com.kai.kaipicturebackend.websocket.model;

import com.kai.kaipicturebackend.model.vo.LoginUserVO;
import lombok.Data;

import java.io.Serializable;

/**
 * 图片编辑响应消息（后端 → 前端，第 12 期 WebSocket）。
 *
 * 第 12 期任务：
 * 1. 理解响应消息的组成：type + message + 操作内容 + 操作人
 * 2. 广播时带上 user（谁在操作），前端可以显示"xx 正在编辑"
 */
@Data
public class PictureEditResponseMessage implements Serializable {

    /**
     * 消息类型
     */
    private String type;

    /**
     * 提示信息
     */
    private String message;

    /**
     * 图片 id
     */
    private Long pictureId;

    /**
     * 编辑操作类型
     */
    private String editAction;

    /**
     * 编辑内容
     */
    private String editContext;

    /**
     * 操作人（脱敏后）
     */
    private LoginUserVO user;

    private static final long serialVersionUID = 1L;
}
