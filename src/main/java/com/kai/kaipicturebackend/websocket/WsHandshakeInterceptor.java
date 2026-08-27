package com.kai.kaipicturebackend.websocket;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import java.util.Map;

/**
 * WebSocket 握手拦截器 —— 建立连接前的权限校验（第 12 期）。
 *
 * 第 12 期任务：
 * 1. 理解 WebSocket 连接前要先"握手"（HTTP 升级），拦截器在握手时执行
 * 2. 实现：从请求 URL 或 Session 中获取登录用户，
 *    校验是否登录、是否有权编辑这张图片
 * 3. 把用户信息放入 attributes，后续 Handler 里能拿到
 * 4. 思考：为什么 WebSocket 也要鉴权？（任何连接都能连的话，就能偷看别人的图片）
 */
public class WsHandshakeInterceptor implements HandshakeInterceptor {

    @Override
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response,
                                   WebSocketHandler wsHandler, Map<String, Object> attributes) throws Exception {
        // TODO 第 12 期：实现握手鉴权
        // 提示：从 request.getURI() 取参数（pictureId），校验登录用户 + 空间成员权限
        return true;
    }

    @Override
    public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response,
                               WebSocketHandler wsHandler, Exception exception) {
    }
}
