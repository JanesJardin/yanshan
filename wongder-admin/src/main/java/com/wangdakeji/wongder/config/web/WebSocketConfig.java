package com.wangdakeji.wongder.config.web;


import com.wangdakeji.wongder.core.websocket.HttpSessionIdHandshakeInterceptor;
import com.wangdakeji.wongder.core.websocket.RequestListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;
import org.springframework.web.socket.server.standard.TomcatRequestUpgradeStrategy;
import org.springframework.web.socket.server.support.DefaultHandshakeHandler;

/**
 * WebSocket 配置类
 * Created by wangda
 * on 17-11-30
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {

//    /**
//     * 提供Endpoint的注册管理
//     * @return
//     */
//    @Bean
//    public ServerEndpointExporter serverEndpointExporter() {
//        return new ServerEndpointExporter();
//    }

    /**
     * 注册一个Stomp的节点（endpoint）,并指定使用SockJS协议。
     * @param stompEndpointRegistry
     */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry stompEndpointRegistry) {
        // 添加服务端点，可以理解为某一服务的唯一key值,当浏览器支持sockjs时执行该配置
        stompEndpointRegistry.addEndpoint("/endpoint-station")
                .setAllowedOrigins("*")
                //.setHandshakeHandler(new DefaultHandshakeHandler(new TomcatRequestUpgradeStrategy()))
                .withSockJS().setInterceptors(new HttpSessionIdHandshakeInterceptor());
    }

    /**
     * 配置消息代理（MessageBroker）
     * @param registry
     */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry){

        // 配置客户端接受订阅前缀
        registry.enableSimpleBroker("/websocket");

        //registry.setApplicationDestinationPrefixes("/alive");//配置客户端发送消息路径前缀
    }

    @Bean
    public HttpSessionIdHandshakeInterceptor httpSessionIdHandshakeInterceptor() {
        return new HttpSessionIdHandshakeInterceptor();
    }
}
