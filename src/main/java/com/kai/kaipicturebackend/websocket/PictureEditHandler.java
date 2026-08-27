package com.kai.kaipicturebackend.websocket;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * WebSocket 图片协同编辑处理器 —— 核心（第 12 期）。
 *
 * 工作流程（要先理解再写）：
 * 1. afterConnectionEstablished：连接建立 → 保存会话到集合 → 广播"xx 进入编辑"
 * 2. handleTextMessage：收到消息 → 按消息类型分发处理
 *    - ENTER_EDIT：加入编辑队列，广播给其他人
 *    - EDIT_ACTION：把编辑动作广播给其他人
 *    - EXIT_EDIT：移除会话，广播"xx 退出编辑"
 * 3. 消息要带上操作人（从握手拦截器存的 attributes 里拿）
 *
 * 第 12 期扩展：消息处理可以接 Disruptor 无锁队列异步化，防止高并发阻塞
 */
public class PictureEditHandler extends TextWebSocketHandler {

    /**
     * 会话集合：pictureId -> 会话列表（同一张图的人）
     */
    private static final Map<Long, Set<WebSocketSession>> PICTURE_EDIT_SESSIONS = new ConcurrentHashMap<>();

    /**
     * 会话 -> 用户信息映射
     */
    private static final Map<WebSocketSession, Object> SESSION_USER_MAP = new ConcurrentHashMap<>();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        // TODO 第 12 期：连接建立后
        // 1. 从 session.getAttributes() 拿 pictureId 和用户
        // 2. 把 session 加入 PICTURE_EDIT_SESSIONS 对应集合
        // 3. 广播：别人"XX 进入了编辑"
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        // TODO 第 12 期：处理客户端消息
        // 1. 解析 JSON → PictureEditRequestMessage
        // 2. 按 type 分发处理（用 PictureEditMessageTypeEnum）
        // 3. 构造 PictureEditResponseMessage 广播给同图的其他会话
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, org.springframework.web.socket.CloseStatus status) throws Exception {
        // TODO 第 12 期：连接关闭后移除会话，广播"XX 退出了编辑"
    }
}
