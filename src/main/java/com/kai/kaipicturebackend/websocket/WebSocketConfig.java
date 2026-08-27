package com.kai.kaipicturebackend.websocket;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * WebSocket 配置 —— 注册处理器和拦截器（第 12 期）。
 *
 * 第 12 期任务：
 * 1. 理解注册规则：/api/ws/picture/edit 是前端连接的地址
 * 2. setAllowedOrigins：允许哪些域名连接（和 HTTP 跨域一样的安全考虑）
 * 3. addInterceptors：注册握手拦截器
 */
@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        // TODO 第 12 期：注册
        // registry.addHandler(new PictureEditHandler(), "/ws/picture/edit")
        //         .addInterceptors(new WsHandshakeInterceptor())
        //         .setAllowedOrigins("*");
    }
}
